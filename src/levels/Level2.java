package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.List;
import java.util.function.Consumer;

public class Level2 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /* TO DO 1: Retourner le nombre des enseignants dont le nom commence avec s */
        long nbr = teachers.stream().filter(s->s.getName().startsWith("s")).count();
        System.out.println(nbr);
        /* TO DO 2: Retourner la somme des salaires de tous les enseignants Flutter (hint: mapToInt) */
        long sum = teachers.stream().filter(s->s.getSubject().equals(Subject.FLUTTER)).mapToInt(i-> i.getSalary()).sum();
        System.out.println(sum);
        /* TO DO 3: Retourner la moyenne des salaires des enseignants dont le nom commence avec a */
        double average = teachers.stream().filter(s->s.getName().startsWith("a"))
                .mapToInt(i-> i.getSalary()).average().getAsDouble();
        System.out.println(average);

        /* TO DO 4: Retourner la liste des enseignants dont le nom commence par f */
        List<Teacher> teachers1 = teachers.stream().filter(s->s.getName().startsWith("f")).toList();
        System.out.println(teachers1);
        /* TO DO 5: Retourner la liste des enseignants dont le nom commence par s */
        List<Teacher> teachers2 = teachers.stream().filter(s->s.getName().startsWith("s")).toList();
        System.out.println(teachers2);

        /* TO DO 5: Retourner true si il y a au min un enseignants dont le salaire > 100000, false si non */
        boolean test = teachers.stream().anyMatch(s->s.getSalary()>100000);
        System.out.println(test);
        /* TO DO 6: Afficher le premier enseignant Unity le nom commence avec g avec 2 manières différentes */
        /*First way*/
        teachers.stream().filter(s->s.getSubject().equals(Subject.UNITY)).filter(s->s.getName().startsWith("g")).limit(1);

        /*Second way*/
        teachers.stream().filter(s->s.getSubject().equals(Subject.UNITY)).filter(s->s.getName().startsWith("g")).findFirst();

        /* TO DO 7: Afficher le deuxième enseignant dont le nom commence avec s */
        teachers.stream().filter(s->s.getName().startsWith("s")).skip(1).findFirst();

    }
}
