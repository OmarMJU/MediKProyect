package com.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.Class;
// import org.apache.log4j.Logger;

//import com.arquitecturajava.SuppressWarnings;

public class DataBaseHelper<T>
{
	
 //private static final Logger log = Logger.getLogger(DataBaseHelper.class);
	
  private static final String Driver = "org.postgresql.Driver";
  private static final String URL = "jdbc:postgresql://localhost:5432/MediK";
  private static final String Usuario = "postgres";
  private static final String Pass = "mysecretpassword";
  
  public int modificarRegistro(String consultaSQL)
  {
    Connection conexion = null;
    Statement sentencia = null;
    int filasAlteradas = 0;

    try
    {
      Class.forName(Driver);
      conexion = DriverManager.getConnection(URL, Usuario, Pass);
      sentencia = conexion.createStatement();
      filasAlteradas = sentencia.executeUpdate(consultaSQL);
    }
    catch(ClassNotFoundException e)
    {
      System.out.println("Error en el driver " + e.getMessage());
    }
    catch(SQLException e)
    {
      System.out.println("Error en SQL " + e.getMessage());
    }
    finally
    {
      if(sentencia != null)
      {
        try
        {
          sentencia.close();
        }
        catch(SQLException e){}
      }

      if(conexion != null)
      {
        try
        {
          conexion.close();
        }
        catch(SQLException e) {}
      }
    }
    return filasAlteradas;
  }

  @SuppressWarnings("unchecked")
  public List<T> selecionarRegitros(String consultaSQL, Class<T> myClass)
  {
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet filas = null;
    ArrayList<T> listaOjetos = new ArrayList<T>();

    try
    {
      Class.forName(Driver);
      conexion = DriverManager.getConnection(URL, Usuario, Pass);
      sentencia = conexion.createStatement();
      filas = sentencia.executeQuery(consultaSQL);

      while(filas.next())
      {
        T objeto = (T)Class.forName(myClass.getName()).newInstance();
        Method[] metodo = objeto.getClass().getDeclaredMethods();

        for (int i = 0; i < metodo.length; i++)
        {
          if(metodo[i].getName().startsWith("set"))
          {
        	  metodo[i].invoke(objeto, filas.getString(metodo[i].getName().substring(3)));
          }
        	  
          if(objeto.getClass().getName().equals("java.lang.String"))
          {
        	  objeto = (T)filas.getString(1);  
          }
        }
        listaOjetos.add(objeto);
      }
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
    finally
    {
      if(sentencia != null)
      try{sentencia.close();} catch(SQLException e){}
      if(conexion != null)
      try{conexion.close();} catch(SQLException e){}
    }
    return listaOjetos;
  }
}