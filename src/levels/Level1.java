package levels;

import models.Subject;
import models.Teacher;
import utils.Data;

import java.util.Comparator;
import java.util.List;

public class Level1 {

    public static void main(String[] args) {
        List<Teacher> teachers = Data.employees();

        /*
         * TO DO 1: Afficher tous les enseignants
         */
        teachers.stream().forEach(System.out::println);
        // Or teachers.stream().forEach(s->System.out.println(s));
        /*
         * TO DO 2: Afficher les enseignants dont le nom commence par la lettre n
         */
        teachers.stream().filter(s->s.getName().startsWith("n")).forEach(System.out::println);

        /*
         * TO DO 3: Afficher les enseignants dont le nom commence par la lettre n et le salaire > 100000
         */
        teachers.stream().filter(s->s.getName().startsWith("n")).filter(s->s.getSalary()>100000).distinct().forEach(System.out::println);

        /*
         * TO DO 4: Afficher les enseignants JAVA triés par salaire (éliminer les redondances)
         */
        teachers.stream().filter(s->s.getSubject().equals(Subject.JAVA)).
                sorted(Comparator.comparingInt(Teacher::getSalary)).forEach(s->System.out.println(s));

        /*
         * TO DO 5: Afficher les noms des enseignants dont le salaire > 60000 avec 2 manières différentes
         */

        /* First Way */
        teachers.stream().filter(s->s.getSalary()>60000).forEach(s->System.out.println(s.getName()));
        /* Second Way */
        teachers.stream().filter(s->s.getSalary()>60000).map(Teacher::getName).forEach(System.out::println);

        /*
         * TO DO 6:  Ajouter 200 Dt pour les enseignants dont le nom commence par m et afficher celui qui a le salaire le plus élevé
         */
        teachers.stream().filter(s->s.getName().startsWith("m")).peek(s->s.setSalary(s.getSalary()+200)).max((a,b)->a.getSalary()-b.getSalary()).ifPresent(teacher -> System.out.println(teacher.getName()));

    }
}
