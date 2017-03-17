package peopleatndsu;

import java.util.ArrayList;
import java.util.Scanner;
import peopleatndsu.ParseFiles;

/**
 *
 * @author Owner
 */
public class PeopleAtNDSU {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<ArrayList<String>> container=new ArrayList();
    
    //I'll be defining a method that will make appropriate modifications to a person object, if they are both equal
    public static void personChanger(Person possibleNew, Person oldPerson) 
        {
            if (possibleNew.equals(oldPerson))
            {
                //Going to have to do some long selection here?

                if (possibleNew.getTitle()==null && oldPerson.getTitle()!=null)
                {
                    possibleNew.setTitle(oldPerson.getTitle());
                }
                else if (possibleNew.getTitle()!=null && oldPerson.getTitle()==null)
                {
                    //Basically do nothing
                }
                else if (!possibleNew.getTitle().equals(oldPerson.getTitle()))
                {
                    if (possibleNew.getTitle().length()<oldPerson.getTitle().length())
                            {
                                possibleNew.setTitle(oldPerson.getTitle());
                            }
                }
                
                if (possibleNew.getMajor()==null && oldPerson.getMajor()!=null)
                {
                    possibleNew.setMajor(oldPerson.getMajor());
                }
                else if (possibleNew.getMajor()!=null && oldPerson.getMajor()==null)
                {
                    //Basically do nothing
                }
                
                if (possibleNew.getYear()==null && oldPerson.getYear()!=null)
                {
                    possibleNew.setYear(oldPerson.getYear());
                }
                else if (possibleNew.getYear()!=null && oldPerson.getYear()==null)
                {
                    //Basically do nothing
                }
                
                if (possibleNew.getCommonClass()==null && oldPerson.getCommonClass()!=null)
                {
                    possibleNew.setCommonClass(oldPerson.getCommonClass());
                }
                else if (possibleNew.getCommonClass()!=null && oldPerson.getCommonClass()==null)
                {
                    //Basically do nothing
                }
                else if (!possibleNew.getCommonClass().equals(oldPerson.getCommonClass()))
                {
                    if (possibleNew.getCommonClass().length()<oldPerson.getCommonClass().length())
                    {
                        possibleNew.setCommonClass(oldPerson.getCommonClass());
                    }
                }
                
                if (possibleNew.getDeansList()==null && oldPerson.getDeansList()!=null)
                {
                    possibleNew.setDeansList(oldPerson.getDeansList());
                }
                else if (possibleNew.getDeansList()!=null && oldPerson.getDeansList()==null)
                {
                    //Basically do nothing
                }
                else if (!possibleNew.getDeansList().equals(oldPerson.getDeansList()))
                {
                    if (possibleNew.getDeansList().length()<oldPerson.getDeansList().length())
                    {
                        possibleNew.setDeansList(oldPerson.getDeansList());
                    }
                }

                

            }
        }
        
    public static void main(String[] args) {
        
        //Here I will combine that data that I've harvested 
        //If anywhere this would be where I would implrement the "historical feature"
        //of my program.
        

        Scanner scan=new Scanner(System.in);
        boolean run=true;
        ParseFiles file=new ParseFiles();
        String searchHere="";
        String orderOfInputFiles="";
        ArrayList <String> deansListEdition=new ArrayList();
        ArrayList <String> className=new ArrayList();
        ArrayList<Person> peopleList=new ArrayList();    
        
        //This loop harvest all the data file locations that I would need
        while (true)
        {
            System.out.println("Press \"D\" for Deans list, press \"C\" for Class Roster, Press \"P\" for Presonal File, Press \"Q\" to quit.");
            char input=scan.nextLine().toLowerCase().charAt(0);
            
            if (input=='d')
            {
                orderOfInputFiles+=input;
                System.out.println("Please enter a valid filename.");
                searchHere=scan.nextLine();
                file.getDeansList(searchHere);
                System.out.println("Please enter the what edition of the list it is.");
                deansListEdition.add(scan.nextLine()+",");
            }
            else if (input=='c')
            {
                orderOfInputFiles+=input;
                System.out.println("Please enter a valid filename.");
                searchHere=scan.nextLine();
                file.parseClassRoster(searchHere);
                System.out.println("Please enter the name of the class.");
                className.add(scan.nextLine()+",");
            }
            else if (input=='p')
            {
                orderOfInputFiles+=input;
                System.out.println("Please enter a valid filename.");
                searchHere=scan.nextLine();
                file.getPerson(searchHere);
                //I'll have to do some more refining of the personal data to get the Strings that I want
                //seeing as I didn't do this in the parse people method in the parse files class.
            }
            else if (input=='q')
            {
               break;
            }
            else 
            {
                System.out.println("Please enter a required character.");
            }
            if (file.getDiscard())
            {
                int removeThis=orderOfInputFiles.length()-1;
                char removeFromList=orderOfInputFiles.charAt(removeThis);
                orderOfInputFiles=orderOfInputFiles.substring(0,removeThis);
                file.setDiscard(false);
                if (removeFromList=='c')
                {
                    int lastOne=className.size();
                    className.remove(lastOne);
                }
                else if (removeFromList=='d')
                {
                    int lastOne=className.size();
                    deansListEdition.remove(lastOne);
                }
            }
        }
        
        //This ensures that some data was entered before it tries to sort/process it.
        if (orderOfInputFiles.length()==0)
        {
            System.err.println("You have no valid input at this time, the program will exit.");
            System.exit(0);
        }
        //This loop will make all of the person objects that I will add to the peopleList 
        //it also adds the people to the list and then compares to see if they are the same, aptly
        //changing them.
        
        while (orderOfInputFiles.length()>0)
        {
            char current=orderOfInputFiles.charAt(0);
            ArrayList<String> dummieList=PeopleAtNDSU.container.get(0);
            
            if (current=='d')
            {
                orderOfInputFiles=orderOfInputFiles.substring(1);
                Scanner line;
                
                for (String s: dummieList)
                {
                    line=new Scanner(dummieList.get(dummieList.indexOf(s)));
                    String firstName=line.next();
                    line.next();
                    String lastName=line.next();
                    
                    String major="";
                    
                    while(line.hasNext())
                    {
                        major+=line.next()+" ";
                    }
                    
                    Person add=new Person();
                    add.setName(firstName+" "+lastName);
                    add.setMajor(major);
                    add.setDeansList(deansListEdition.get(0));
                    
                    for (Person p: peopleList)
                    {
                        if (p.equals(add))
                        {
                            personChanger(add,p);
                            peopleList.remove(p);
                            break;
                        }
                    }
                    peopleList.add(add);
                    
                }
                deansListEdition.remove(0);
            }
            else if (current=='c')
            {
                orderOfInputFiles=orderOfInputFiles.substring(1);
                Scanner line;
                
                for (String s: dummieList)
                {
                    Person add=new Person();
                    add.setName(s);
                    add.setCommonClass(className.get(0));
                    for (Person p: peopleList)
                    {
                        if (p.equals(add))
                        {
                            personChanger(add,p);
                            peopleList.remove(p);
                            break;
                        }
                    }
                    peopleList.add(add);
                }
            }
            else if (current=='p')
            {
                orderOfInputFiles=orderOfInputFiles.substring(1);
                for (String s: dummieList)
                {
                    String name="";
                    String major="";
                    String year="";
                    String title="";
                    Scanner line=new Scanner(s);
                    while (line.hasNextLine())
                    {
                        String temp=line.nextLine();
                        if (temp.contains("*Name*"))
                        {
                            while (temp.contains("*"))
                            {
                                temp=temp.substring(1);
                            }
                            temp=temp.trim();
                            name=temp;
                        }
                        else if (temp.contains("*Affiliation*"))
                        {
                            while (temp.contains("*"))
                            {
                                temp=temp.substring(1);
                            }
                            temp=temp.trim();
                            title=temp;
                        }
                        else if (temp.contains("*Class*"))
                        {
                            while (temp.contains("*"))
                            {
                                temp=temp.substring(1);
                            }
                            temp=temp.trim();
                            year=temp;
                        }
                        else if (temp.contains("*Major*"))
                        {
                            while (temp.contains("*"))
                            {
                                temp=temp.substring(1);
                            }
                            temp=temp.trim();
                            major=temp;
                        }
                    }
                    Person add=new Person();
                    add.setName(name);
                    add.setMajor(major);
                    add.setYear(year);
                    add.setTitle(title);
                    for (Person p: peopleList)
                    {
                        if (p.equals(add))
                        {
                            personChanger(add,p);
                            peopleList.remove(p);
                            break;
                        }
                    }
                    peopleList.add(add);
                }
            }
            container.remove(dummieList);
            container.trimToSize();
        }
        while (true)
        {
            System.out.println("Please enter a sorting method.\n M=\t Major \n D=\t Deans List"
                    + "\n N=\t Name \n T= \t Title \n Y= \t Year \n C= \t Common Class");
            String temp=scan.nextLine().toLowerCase();
            char trial=temp.charAt(0);
            
            if (trial=='t')
            {
                System.out.println("What title are you searching for?");
                String input=scan.nextLine();
                
                for (Person p: peopleList)
                {
                    if (input.equals(p.getTitle()) || input.contains(p.getTitle()))
                    {
                        System.out.println(p.toString());
                    }
                }
            }
            else if (trial=='m')
            {
                System.out.println("What major were you looking for?");
                String input=scan.nextLine();
                
                 for (Person p: peopleList)
                {
                    if (input.equals(p.getMajor()) || input.contains(p.getMajor()))
                    {
                        System.out.println(p.toString());
                    }
                }
                
            }
            else if (trial=='d')
            {
                System.out.println("Please enter the semester, followed by the year number.");
                String input=scan.nextLine();
                 for (Person p: peopleList)
                {
                    if (input.equals(p.getDeansList()) || p.getDeansList().contains(input))
                    {
                        System.out.println(p.toString());
                    }
                }
            }
            else if (trial=='n')
            {
                System.out.println("Please enter a name you would like to search for.");
                String input=scan.nextLine();
                
                 for (Person p: peopleList)
                {
                    if (input.equals(p.getName()) || input.contains(p.getName()))
                    {
                        System.out.println(p.toString());
                    }
                }
            }
            else if (trial=='y')
            {
                System.out.println("What year in college are you looking for?");
                String input=scan.nextLine();
                
                 for (Person p: peopleList)
                {
                    if (input.equals(p.getYear()))
                    {
                        System.out.println(p.toString());
                    }
                }
                
            }
            else if (trial=='c')
            {
                System.out.println("Please enter the common class.");
                String input=scan.nextLine();
                
                 for (Person p: peopleList)
                {
                    if (input.equals(p.getCommonClass()) || p.getCommonClass().contains(input))
                    {
                        System.out.println(p.toString());
                    }
                }
            } 
        }
    }
    
}
