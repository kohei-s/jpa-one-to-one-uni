package com.koheis.jpaonetoone;

import com.koheis.jpaonetoone.dao.AppDAO;
import com.koheis.jpaonetoone.entity.Instructor;
import com.koheis.jpaonetoone.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaOneToOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaOneToOneApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
            // createInstructor(appDAO);

            findInstructor(appDAO);
        };
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding instructor id: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

        /*
        // create the instructor
        Instructor tempInstructor = new Instructor("Chad", "Derby", "derby@test.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "Chad's Youtube Channel",
                "Coding");
         */

        // create the instructor
        Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@test.com");

        // create the instructor detail
        InstructorDetail tempInstructorDetail = new InstructorDetail(
                "Madhu's Youtube Channel",
                "Guitar");

        // associate the objects
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        // save the instructor
        // NOTE: this will ALSO save the detail object
        // because of the CascadeType.ALL
        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);

        System.out.println("Done!");
    }

}
