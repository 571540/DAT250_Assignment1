# Assignment 2 Short Report

## Installation: Derby Database

Following the tutorial went fine, but it took some time getting used to how it worked. I downloaded an older version for making it work with jdk 8, which I was using. However, problems started when I was going to make it work along with experiment 1.

## Experiment 1: Application using JPA

This part ended up being more time consuming and frustraiting then I expected. I began following the tutorial: https://www.vogella.com/tutorials/JavaPersistenceAPI/article.html#installation, but I got several errors in my java project so ended up using the available Maven project as a starting point instead. I still got issues related to the JDK-version I had, and some other errors. I had to go into build path, persistance.xml, pom.xml and other settings and change them so it would work with my setup. I then ran the program and finally made it work with Derby. I used the ij scripting tool and connected to the database. I inspected if the data was created by running a SQL script. After that, I copy-pasted the classes from the original tutorial (vogella) into this project and it worked as well.

## Experiment 2: Banking/Credit Card example

Now that all my technical problems was fixed with experiment 1, I just copied my project from experiment 1 and deleted all the classes so I could make the banking app. I took some time, but I got it done. The hardest part was to find out the correct relations and mappings in JPA. The videos from Lars about the topic helped me understand how it worked. I then ran the program and inspected it with ij, just like in experiment 1.

Here is a screenshot just to show an example:
![inspecting data](https://github.com/571540/DAT250_Assignment1/blob/master/images/ex2.PNG)

Here are the repository for both Experiment 1 & 2: https://github.com/571540/DAT250_Assignment1/tree/master/Assignment2
