
import java.lang.reflect.Array;
import java.util.*;

public class LibretaDeNotas {
    public static void main(String[] args) {

        Scanner Inspector = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> alumnosEnGeneral = new HashMap<>();
        System.out.println("ingresa el numero de alumnos ");
        Integer numeroAlumnos = Inspector.nextInt();

        for (int i = 0; i < numeroAlumnos; i++) {
            System.out.println("Ingresa el nombre del alumno " + (1 + i ) + ":");
            String NombreAlumno = Inspector.next();
            alumnosEnGeneral.put(NombreAlumno, new ArrayList<>());
            System.out.println("Ingresa la cantidad de notas a ingresar");
            Integer CantidadNotas = Inspector.nextInt();
            for (int j = 0; j < CantidadNotas; j++) {
                System.out.println("Las notas Deben ser ingresadas de a 1 \n " +"Ingresa la " + ( 1 + j) + " Nota ");
                Integer notasss = Inspector.nextInt();

                if(notasss < 0 || notasss > 7){
                    System.out.println("Ingresado un valor no permitido  \n Este Programa se autroDestruira en  \n 10 \n 9 \n 8 \n 7 \n 6 \n 5\n 4 \n 3 \n 2 \n 1 \n BOOOOOOOOOOOOOOOM \n SALTANDO ESTE USUARIO" );
                    break;
                }
                else {}
                alumnosEnGeneral.get(NombreAlumno).add(notasss);
            }
        }



        while (true){
            System.out.println("Ingrese una opcion o 0) para salir del menu \n 1)  Mostrar Promedios Alumnos  \n 2) Mostrar Notras Aprobatorias o Reprobatorias \n 3) - Ver Promedio Del Curso \n 0)  Salir Del menu ");
            Integer opcion = Inspector.nextInt();
            if (opcion == 0){
                System.out.println("SEE YOU NEXT TIME SPACE COWBOY ");
                break;
            } else {
                switch (opcion) {
                    case 1:
                        for (String NombreAlumno : alumnosEnGeneral.keySet()) {
                            ArrayList<Integer> Notas = alumnosEnGeneral.get(NombreAlumno);
                            float Suma = 0;
                            for (int i = 0; i < Notas.size(); i++) {
                                Suma += Notas.get(i);
                            }
                            float Promedio = Suma / Notas.size();
                            System.out.println("El promedio de notas de  " + NombreAlumno + " ES " + Promedio +" Siendo su nota mas alta un = "+ Collections.max(Notas) + " Y su nota mas baja un " + Collections.min(Notas));}
                        break;
                    case 2:

                        for (String NombreAlumno : alumnosEnGeneral.keySet()) {
                            ArrayList<Integer> Notas = alumnosEnGeneral.get(NombreAlumno);
                            float Suma = 0;
                            for (int i = 0; i < Notas.size(); i++) {
                                Suma += Notas.get(i);
                            }
                            float Promedio = Suma / Notas.size();
                            if (Promedio > 4.0 ){
                                System.out.println("El alumno " + NombreAlumno + "Aprobo el ramo con un promedio de   " + Promedio );
                            }
                            else if (Promedio < 4.0 ){
                                System.out.println("Alumno" + NombreAlumno + "Reprobo el ramo con un  " + Promedio);
                            }
                        }
                        break;
                    case 3 :
                        float sumaCurso = 0;
                        int cantidadNotas = 0;
                        for (String nombreAlumno : alumnosEnGeneral.keySet()) {
                            ArrayList<Integer> notas = alumnosEnGeneral.get(nombreAlumno);
                            for (float nota : notas) {
                                sumaCurso += nota;
                                cantidadNotas++;
                            }
                        }
                        float promedioCurso = sumaCurso / cantidadNotas;
                        for (String nombreAlumno : alumnosEnGeneral.keySet()) {
                            ArrayList<Integer> notas = alumnosEnGeneral.get(nombreAlumno);
                            float suma = 0;
                            for (float nota : notas) {
                                suma += nota;
                            }
                            float promedioAlumno = suma / notas.size();
                            if (promedioAlumno > promedioCurso) {
                                System.out.println(nombreAlumno + " tiene un promedio mayor que el promedio del curso (" + promedioAlumno + " vs " + promedioCurso + ")");
                            } else if (promedioAlumno < promedioCurso) {
                                System.out.println(nombreAlumno + " tiene un promedio menor que el promedio del curso (" + promedioAlumno + " vs " + promedioCurso + ")");
                            } else {
                                System.out.println(nombreAlumno + " tiene un promedio igual al promedio del curso (" + promedioAlumno + " vs " + promedioCurso + ")");
                            }
                        }
                        break;
                    default:
                        System.out.println("Si vez esto es que algo salio mal ");
                        break;
                }
            }
        }

    }


}
