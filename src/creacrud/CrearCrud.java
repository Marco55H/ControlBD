package creacrud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CrearCrud {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Bienvenido al sistema gestor de bases de datos");
		try {
			Menu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Gracias por usar el programa");
		sc.close();
	}

	private static void borrar() throws ClassNotFoundException, SQLException {
		int opc2;
		System.out.println("En que tabla quiere BORRAR (Tendrá que estar creada)");
		System.out.println(" -------------------------------- ");
		System.out.println(" 1 -Profesores (También eliminará Matricula)");
		System.out.println(" 2 -Alumnado (También eliminará Matricula) ");
		System.out.println(" 3 -Matrícula");
		opc2 = sc.nextInt();
		sc.nextLine();
		switch (opc2) {
		case 1:			
			borrarTabla("Matricula");
			borrarTabla("Profesor");
			break;
		case 2:
			borrarTabla("Matricula");
			borrarTabla("Alumno");
			break;
		case 3:
			borrarTabla("Matricula");
			break;
		}
	}
	
	private static void borrarTabla(String tabla) throws SQLException, ClassNotFoundException {
	Connection conn = null;
    Statement stmt = null;
    
    conn = Conectar();
	System.out.println("Nos hemos conectado a la BBDD");

	stmt = conn.createStatement();
	
	stmt.executeUpdate("Delete from "+tabla);
	System.out.println("Eliminada correctamente");
}
 
	private static void editar() throws ClassNotFoundException, SQLException {
		int opc2;
		System.out.println("En que tabla quiere EDITAR (Tendrá que estar creada)");
		System.out.println(" -------------------------------- ");
		System.out.println(" 1 -Profesores");
		System.out.println(" 2 -Alumnos");
		System.out.println(" 3 -Matrícula");
		opc2 = sc.nextInt();
		sc.nextLine();

		switch (opc2) {
		case 1:
			editarProfesor();
			break;
		case 2:
			editarAlumno();
			break;
		case 3:
			editarMatricula();
			break;
		}
	}
	
	private static void editarMatricula() throws ClassNotFoundException, SQLException {
		int idMatricula;
		String modificar="";
	    Connection conn = null;
	    Statement stmt = null;
	    int idProfesorado ;
	    int idAlumnado;
	    int curso;
	    String Asignatura="";

	    
		System.out.println("Inserte el ID de la Matricula que quiere modificar");
		idMatricula = sc.nextInt();
		sc.nextLine();
		
		//Nombre
		System.out.println("¿Quiere modificar el idProfesorado?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es el nuevo idProfesorado de la Matricula "+idMatricula);
	    	idProfesorado=sc.nextInt();
	    	sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Matricula SET idProfesorado = '"+idProfesorado+"' WHERE id = "+idMatricula+";");
			System.out.println("Editado correctamente");
	    	
		}
		
		//Apellido
		System.out.println("¿Quiere modificar el idAlumnado?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es el nuevo idAlumnado de la Matricula "+idMatricula);
	    	idAlumnado=sc.nextInt();
	    	sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Matricula SET idAlumnado = '"+idAlumnado+"' WHERE id = "+idMatricula+";");
			System.out.println("Editado correctamente");
	    	
		}
		
		//fechanacimiento
		System.out.println("¿Quiere modificar el curso?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es el nuevo curso de la Matricula "+idMatricula);
	    	curso=sc.nextInt();
	    	sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Matricula SET Curso = '"+curso+"' WHERE id = "+idMatricula+";");
			System.out.println("Editado correctamente");
	    	
		}
		//antiguedad
		System.out.println("¿Quiere modificar la Asignatura?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es  la nueva Asignatura de la Matricula "+idMatricula);
	    	Asignatura=sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Matricula SET Asignatura = '"+Asignatura+"' WHERE id = "+idMatricula+";");
			System.out.println("Editado correctamente");
	    	
		}
		
	}

	private static void editarAlumno() throws ClassNotFoundException, SQLException {
		int idAlumno;
		String modificar="";
	    Connection conn = null;
	    Statement stmt = null;
	    String nombre="";
	    String fechanacimiento="";
	    String apellido="";

	    
		System.out.println("Inserte el ID del alumno que quiere modificar");
		idAlumno = sc.nextInt();
		sc.nextLine();
		
		//Nombre
		System.out.println("¿Quiere modificar el nombre?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es el nuevo nombre del alumno "+idAlumno);
	    	nombre=sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Alumno SET nombre = '"+nombre+"' WHERE id = "+idAlumno+";");
			System.out.println("Editado correctamente");
	    	
		}
		
		//Apellido
		System.out.println("¿Quiere modificar el apellido?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es el nuevo apellido del alumno "+idAlumno);
	    	apellido=sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Alumno SET apellidos = '"+apellido+"' WHERE id = "+idAlumno+";");
			System.out.println("Editado correctamente");
	    	
		}
		
		//fechanacimiento
		System.out.println("¿Quiere modificar la Fecha de Nacimiento?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es  la nueva Fecha de Nacimiento del alumno "+idAlumno+" (Este formato) 1974-12-11");
	    	fechanacimiento=sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Alumno SET fechanacimiento = '"+fechanacimiento+"' WHERE id = "+idAlumno+";");
			System.out.println("Editado correctamente");
	    	
		}
		
	}
	
	private static void editarProfesor() throws ClassNotFoundException, SQLException {
		int idProfesor;
		String modificar="";
	    Connection conn = null;
	    Statement stmt = null;
	    String nombre="";
	    String fechanacimiento="";
	    String apellido="";
	    int antiguedad;

	    
		System.out.println("Inserte el ID del profeor que quiere modificar");
		idProfesor = sc.nextInt();
		sc.nextLine();
		
		//Nombre
		System.out.println("¿Quiere modificar el nombre?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es el nuevo nombre del profesor "+idProfesor);
	    	nombre=sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Profesor SET nombre = '"+nombre+"' WHERE id = "+idProfesor+";");
			System.out.println("Editado correctamente");
	    	
		}
		
		//Apellido
		System.out.println("¿Quiere modificar el apellido?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es el nuevo apellido del profesor "+idProfesor);
	    	apellido=sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Profesor SET apellidos = '"+apellido+"' WHERE id = "+idProfesor+";");
			System.out.println("Editado correctamente");
	    	
		}
		
		//fechanacimiento
		System.out.println("¿Quiere modificar la Fecha de Nacimiento?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es  la nueva Fecha de Nacimiento del profesor "+idProfesor+" (Este formato) 1974-12-11");
	    	fechanacimiento=sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Profesor SET fechanacimiento = '"+fechanacimiento+"' WHERE id = "+idProfesor+";");
			System.out.println("Editado correctamente");
	    	
		}
		//antiguedad
		System.out.println("¿Quiere modificar la antiguedad?(Si, No)");
		modificar=sc.nextLine();

		if(modificar.toLowerCase().equals("Si".toLowerCase())) {
			conn = Conectar();
	    	System.out.println("Nos hemos conectado a la BBDD");

	    	stmt = conn.createStatement();
	    	
	    	System.out.println("Cuál es  la nueva antiguedad del profesor "+idProfesor);
	    	antiguedad=sc.nextInt();
	    	sc.nextLine();
	    	
			stmt.executeUpdate("UPDATE Profesor SET antiguedad = '"+antiguedad+"' WHERE id = "+idProfesor+";");
			System.out.println("Editado correctamente");
	    	
		}
		
	}
	
	private static void listar() {
		int opc2;
		System.out.println("Que tabla quieres LISTAR (Tendrá que estar creada)");
		System.out.println(" -------------------------------- ");
		System.out.println(" 1 -Profesores");
		System.out.println(" 2 -Matrícula ");
		System.out.println(" 3 -Alumnado");
		opc2 = sc.nextInt();
		sc.nextLine();
		switch (opc2) {
		case 1:
			listarProfesores();
			break;
		case 2:
			listarMatriculas();
			break;
		case 3:
			listarAlumno();
			break;
		}
	}

	public static void listarMatriculas() {
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	        // Conectar a la base de datos
	        conn = Conectar();
	        stmt = conn.createStatement();
	        PreparedStatement pstmt = conn.prepareStatement("Select * from Matricula");
	        ResultSet resultado = pstmt.executeQuery();
	        
	        System.out.printf("%-5s | %-15s | %-15s | %-20s | %-10s%n", 
	                  "Id", "idProfesorado", "idAlumnado", "Asignatura", "Curso");
	        System.out.println("--------------------------------------------------------------------------------------");

	      //Paso 3. Imprimir el resultado
	      while(resultado.next()){
	    	  int id = resultado.getInt("id");
	    	  int idProfesorado = resultado.getInt("idProfesorado");
	    	  int idAlumnado = resultado.getInt("idAlumnado");
	    	  String Asignatura = resultado.getString("Asignatura");
	    	  int curso = resultado.getInt("Curso");
	    	  
	    	  System.out.printf("%-5d | %-15d | %-15d | %-20s | %-10s%n", 
	                  id, idProfesorado, idAlumnado, Asignatura, curso);
	      }

	      resultado.close();
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	           try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}          
	    }
	}
	
	public static void listarProfesores() {
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	        // Conectar a la base de datos
	        conn = Conectar();
	        stmt = conn.createStatement();
	        PreparedStatement pstmt = conn.prepareStatement("Select * from Profesor");
	        ResultSet resultado = pstmt.executeQuery();
	        
	        System.out.printf("%-5s | %-20s | %-20s | %-15s | %-10s%n", 
	                  "Id", "Nombre", "Apellido", "Fecha Nacimiento", "Antigüedad");
	        System.out.println("--------------------------------------------------------------------------------------");

	      //Paso 3. Imprimir el resultado
	      while(resultado.next()){
	    	  int id = resultado.getInt("id");
	    	  String nombre = resultado.getString("nombre");
	    	  String apellido = resultado.getString("apellidos");
	    	  String FechaNacimiento = resultado.getString("FechaNacimiento");
	    	  int antiguedad = resultado.getInt("antiguedad");
	    	  
	    	  System.out.printf("%-5d | %-20s | %-20s | %-15s | %-10d%n", 
	                  id, nombre, apellido, FechaNacimiento, antiguedad);
	      }

	      resultado.close();
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	           try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}          
	    }
	}
	
	public static void listarAlumno() {
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	        // Conectar a la base de datos
	        conn = Conectar();
	        stmt = conn.createStatement();
	        PreparedStatement pstmt = conn.prepareStatement("Select * from Alumno");
	        ResultSet resultado = pstmt.executeQuery();
	        System.out.printf("%-5s | %-20s | %-20s | %-15s%n", "Id", "Nombre", "Apellido", "Fecha Nacimiento");
	        System.out.println("---------------------------------------------------------------");
	      //Paso 3. Imprimir el resultado
	      while(resultado.next()){
	    	  int id = resultado.getInt("id");
	    	  String nombre = resultado.getString("nombre");
	    	  String apellido = resultado.getString("apellidos");
	    	  String FechaNacimiento = resultado.getString("FechaNacimiento");
	    	  
	    	  System.out.printf("%-5d | %-20s | %-20s | %-15s%n", id, nombre, apellido, FechaNacimiento);

	      }

	      resultado.close();
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	           try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}          
	    }
	}

	private static void insertar() {
		int opc2;
		System.out.println("En que tabla quiere INSERTAR (Tendrá que estar creada)");
		System.out.println(" -------------------------------- ");
		System.out.println(" 1 -Profesores");
		System.out.println(" 2 -Matrícula ");
		System.out.println(" 3 -Alumnado");
		opc2 = sc.nextInt();
		sc.nextLine();
		switch (opc2) {
		case 1:
			InsertarValores("profesores");
			break;
		case 2:
			InsertarValores("matricula");
			break;
		case 3:
			InsertarValores("alumnos");
			break;
		}
	}
	
	public static void InsertarValores(String tabla) {
	    Connection conn = null;
	    Statement stmt = null;
	    try {
	    	
	    	conn = Conectar();
	    	
	    	System.out.println("Nos hemos conectado a la BBDD");
	        String sql = "";
	        
	        if(tabla=="alumnos") {
	        	sql=insertAlumno();
	        }else if(tabla=="profesores") {
	        	sql=insertProfesor();
	        }else {
	        	sql=insertMatricula();
	        }
	        
	    	stmt = conn.createStatement();

	        stmt.executeUpdate(sql);
	        System.out.println("Insertado");
	        
	    } catch (SQLException se) {
	        se.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	           try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}          
	    }
	}

	private static String insertMatricula() {
		
		int id=0;
		int idProfesorado=0;
		int idAlumnado=0;
		String asignatura="";
		int curso=0;
		
		System.out.println("Inserta el ID de la Matricula");
		id=sc.nextInt();
		sc.nextLine();
		System.out.println("Inserta el ID del PROFESOR de la Matricula");
		idProfesorado=sc.nextInt();
		sc.nextLine();
		System.out.println("Inserta el ID del ALUMNO de la Matricula");
		idAlumnado=sc.nextInt();
		sc.nextLine();
		System.out.println("Inserta la ASIGNATURA Matriculada");
		asignatura=sc.next();
		System.out.println("Inserta el CURSO en el que se Matricula");
		curso=sc.nextInt();
		sc.nextLine();

		System.out.println("Matricula:  "+id+", "+idProfesorado+", "+idAlumnado+", "+asignatura+", "+curso);
		
		return "INSERT INTO Matricula (id, idProfesorado, idAlumnado, asignatura, curso) VALUES ("+id+", '"+idProfesorado+"', '"+idAlumnado+"', '"+asignatura+"', '"+curso+"');";
	}
	
	private static String insertProfesor() {
		
		int id=0;
		String nombre="";
		String apellidos="";
		String fecha="";
		int antiguedad=0;
		
		System.out.println("Inserta el ID del Profesor");
		id=sc.nextInt();
		sc.nextLine();
		System.out.println("Inserta el NOMBRE del Profesor");
		nombre=sc.next();
		System.out.println("Inserta los APELLIDOS del Profesor");
		apellidos=sc.next();
		System.out.println("Inserta la FECHA de nacimiento del Alumno \n(este formato: '1974-12-11')");
		fecha=sc.next();
		System.out.println("Inserta la ANTIGUEDAD del Profesor");
		antiguedad=sc.nextInt();
		sc.nextLine();

		System.out.println("Profesor:  "+id+", "+nombre+", "+apellidos+", "+fecha+", "+antiguedad);
		
		return "INSERT INTO Profesor (id, nombre, apellidos, FechaNacimiento, antiguedad) VALUES ("+id+", '"+nombre+"', '"+apellidos+"', '"+fecha+"', '"+antiguedad+"');";
	}
	
	private static String insertAlumno() {
		
		int id=0;
		String nombre="";
		String apellidos="";
		String fecha="";
		
		System.out.println("Inserta el ID del Alumno");
		id=sc.nextInt();
		sc.nextLine();
		System.out.println("Inserta el NOMBRE del Alumno");
		nombre=sc.next();
		System.out.println("Inserta los APELLIDOS del Alumno");
		apellidos=sc.next();
		System.out.println("Inserta la fecha de nacimiento del Alumno \n(este formato: '1974-12-11')");
		fecha=sc.next();

		System.out.println("Alumno:  "+id+", "+nombre+", "+apellidos+", "+fecha);
		
		return "INSERT INTO Alumno (id, nombre, apellidos, FechaNacimiento) VALUES ("+id+", '"+nombre+"', '"+apellidos+"', '"+fecha+"');";
	}
	
 	private static void crearTabla() throws Exception {
		int opc2;
		System.out.println("Que tabla quieres CREAR");
		System.out.println(" -------------------------------- ");
		System.out.println(" 1 -Profesores");
		System.out.println(" 2 -Alumnado");
		System.out.println(" 3 -Matrícula (Para crear la matrícula necesitas Alumnos y Profesores, se crearan automáticamente si no existen)");
		System.out.println(" 4 -Todas");
		opc2 = sc.nextInt();
		sc.nextLine();
		switch (opc2) {
		case 1:
			creacionTablaProfesor();
			break;
		case 2:
			creacionTablaAlumno();
			break;
		case 3:
			creacionTablaProfesor();
			creacionTablaAlumno();
			creacionTablaMatricula();
			break;
		case 4:
			creacionTablaProfesor();
			creacionTablaAlumno();
			creacionTablaMatricula();
			break;
		}
	}

	public static Connection Conectar() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String conexionUrl = "jdbc:mysql://dns11036.phdns11.es:3306/ad2425_mholguin?" + "user=mholguin&password=12345";
		Connection con = DriverManager.getConnection(conexionUrl);
		return con;
	}

	public static void creacionTablaAlumno() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = Conectar();
			// Paso 2. Creamos un nuevo objeto con la conexión
			stmt = conn.createStatement();
			// Paso 3. Definimos la sentencia de crear una nueva base de datos
			String sql = "CREATE TABLE IF NOT EXISTS Alumno(" + "id INT Primary Key," + "nombre varchar(50),"
					+ "apellidos varchar(50)," + "FechaNacimiento Date);";
			// Paso 4. Ejecutar la sentencia
			stmt.executeUpdate(sql);

			leerArchivo("alumno");

			System.out.println("tabla Alumno creada");
		} catch (SQLException se) {
			// Gestionamos los posibles errores que puedan surgir durante la ejecucion de la
			// insercion
			se.printStackTrace();
		} catch (Exception e) {
			// Gestionamos los posibles errores
			e.printStackTrace();
		} finally {
			// Paso 5. Cerrar el objeto en uso y la conexión
			stmt.close();
			conn.close();
		}
	}

	public static void creacionTablaMatricula() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = Conectar();
			// Paso 2. Creamos un nuevo objeto con la conexión
			stmt = conn.createStatement();
			// Paso 3. Definimos la sentencia de crear una nueva base de datos
			String sql = "CREATE TABLE IF NOT EXISTS Matricula(" + "id INT Primary Key," + "idProfesorado int,"
					+ "idAlumnado int," + "Asignatura VarChar(50)," + "Curso int,"
					+ "Constraint fkProfesor FOREIGN KEY (idProfesorado) REFERENCES Profesor(id),"
					+ "Constraint fkAlumno FOREIGN KEY (idAlumnado) REFERENCES Alumno(id));";
			// Paso 4. Ejecutar la sentencia
			stmt.executeUpdate(sql);

			leerArchivo("matricula");

			System.out.println("Tabla Matricula creada");
		} catch (SQLException se) {
			// Gestionamos los posibles errores que puedan surgir durante la ejecucion de la
			// insercion
			se.printStackTrace();
		} catch (Exception e) {
			// Gestionamos los posibles errores
			e.printStackTrace();
		} finally {
			// Paso 5. Cerrar el objeto en uso y la conexión
			stmt.close();
			conn.close();
		}
	}

	public static void creacionTablaProfesor() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			// Paso 1.Previamente habremos realizado la conexión
			conn = Conectar();
			// Paso 2. Creamos un nuevo objeto con la conexión
			stmt = conn.createStatement();
			// Paso 3. Definimos la sentencia de crear una nueva base de datos
			String sql = "CREATE TABLE IF NOT EXISTS Profesor(" + "id INT Primary Key," + "nombre varchar(50),"
					+ "apellidos varchar(50)," + "FechaNacimiento Date," + "antiguedad int);";
			// Paso 4. Ejecutar la sentencia
			stmt.executeUpdate(sql);

			leerArchivo("profesor");

			System.out.println("Tabla Profesor creada");
		} catch (SQLException se) {
			// Gestionamos los posibles errores que puedan surgir durante la ejecucion de la
			// insercion
			se.printStackTrace();
		} catch (Exception e) {
			// Gestionamos los posibles errores
			e.printStackTrace();
		} finally {
			// Paso 5. Cerrar el objeto en uso y la conexión
			stmt.close();
			conn.close();
		}
	}

	public static String leerArchivo(String tipoArchivo) {

		BufferedReader br = null;

		String resultado = "";

		try {
			br = new BufferedReader(new FileReader("src//creacrud//" + tipoArchivo + ".txt"));

			String linea = "";

			linea = br.readLine();

			while (linea != null) {
				resultado = "";
				resultado += linea;
				insertarValores(resultado);
				linea = br.readLine();
			}
			System.out.println("Archivo Leido");
		} catch (Exception e) {
			System.out.println("Ha ocurrido un error a la hora de leer el archivo");
		}

		return resultado;

	}

	public static void insertarValores(String insert) {
		System.out.println(insert);
		Connection conn = null;
		Statement stmt = null;
		try {
			// Conectar a la base de datos
			conn = Conectar();
			stmt = conn.createStatement();
			System.out.println("Nos hemos conectado a la BBDD");
			stmt.executeUpdate(insert); // Ejecuta la consulta
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				System.out.println("No se ha podido cerrar la conexión.");
			}
		}
	}

	private static void Menu() throws Exception {
		int opc = 0;
		do {
			System.out.println(" -------------------------------- ");
			System.out.println("|	Elije una opción         |");
			System.out.println("|	1- Insertar              |");
			System.out.println("|	2- Listar                |");
			System.out.println("|	3- Editar                |");
			System.out.println("|	4- Borrar                |");
			System.out.println("|	9- Crear tabla           |");
			System.out.println("|	0- Salir                 |");
			System.out.println(" -------------------------------- ");

			opc = sc.nextInt();
			sc.nextLine();

			switch (opc) {
			case 9:
				crearTabla();
				break;

			case 1:
				insertar();
				break;

			case 2:
				listar();
				break;

			case 3:
				editar();
				break;

			case 4:
				borrar();
				break;
			}

		} while (opc != 0);
	}
}
