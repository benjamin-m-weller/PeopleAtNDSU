/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopleatndsu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class ParseFiles 
{
    //I think that I will need to place these variables into their respectrive
    //this would allow me to have a default constructor that basically is static?
    public ArrayList<String> personalSearchText=new ArrayList();
    public ArrayList<String> fullDeansListText=new ArrayList();
    public ArrayList<String> classRosterNames=new ArrayList();
    public boolean discard=false;//This variable will determine if the filename will be important.
    
    /*
    I would like a simple GUI to take in the String file names. 
    So I'll do my parsing in a method.
    */
    public boolean getDiscard()
    {
        return discard;
    }
    
    public void setDiscard(boolean discard)
    {
        this.discard=discard;
    }
   
        
    public void getPerson(String fileName)
    {
        String endHere="Student Focused. Land Grant.";
        String startHere=" 1.";
        String addToArray="";
        if (fileName.trim().equals(""))
        {
            System.err.println("You entered a null file address.");
            return;
        }
        try 
        {
            //The below code will start reading to a file.
            Scanner line = new Scanner(new File(fileName));
            
            //This ensures that I'm reading the file in the appropriate way.
            //The following code also ensures that  I only capture what I want.
            boolean addNextLine=false;
            int lineCounter=0;
            while (line.hasNextLine()) 
            {
                String temp = line.nextLine();
                lineCounter++;
                if (temp.contains(startHere)) //This is the start case
                {
                    addNextLine=true;
                    addToArray+=temp +"\n";
                    continue; //This ensures I don't have two header lines
                }
                
                /*
                The following if statements needs to "interupt" such that I don't
                have an extra line in each one of my strings
                */
                
                if (temp.contains(endHere)) //This is the end case
                {
                    break;
                }
                
                /*
                The following if statement runs between the start and end case.
                */
                
                if (addNextLine) 
                {
                    addToArray+=temp +"\n";
                }   
            }
            line.close();
            personalSearchText.add(addToArray);
            personalSearchText.trimToSize();
            PeopleAtNDSU.container.add(personalSearchText);
            PeopleAtNDSU.container.trimToSize();
        } 
        catch (FileNotFoundException fnfe) 
        {
            discard=true;
            System.err.println("The file you entered doesn't exist.");
        }
    }
    
    public void getDeansList(String fileName)
    {
        boolean collect=false;
        if (fileName.trim().equals(""))
        {
            System.err.println("You entered a null file address.");
            return;
        }
        try 
        {
            //The below code will start reading to a file.
            Scanner line = new Scanner(new File(fileName));
            
            //This ensures that I'm reading the file in the appropriate way.
            //The following code also ensures that  I only capture what I want.
            boolean addNextLine=false;
            while (line.hasNextLine()) 
            {
                String temp = line.nextLine();
                
                /*
                I'll need to check to see if the word Name has been read in
                then proceed to check untill we reach a point where we get a
                empty line. If the line is empty then we have to wait until we 
                get a line that has the word Name in it.
                */
                
                if (temp.contains("Name"))
                {
                    collect=true;
                    continue;
                }
                if (temp.isEmpty())
                {
                    collect=false;
                    continue;
                }
                if (collect)
                {
                    fullDeansListText.add(temp);
                    fullDeansListText.trimToSize();
                }
                if (temp.contains("IF YOU"))
                {
                    break;
                }
                
            }
            line.close();
            PeopleAtNDSU.container.add(fullDeansListText);
            PeopleAtNDSU.container.trimToSize();
        } 
        catch (FileNotFoundException fnfe) 
        {
            discard=true;
            System.err.println("The file you entered doesn't exist.");
        }
    }
    
    public void parseClassRoster(String fileName)
    {
        boolean collect=false;
        if (fileName.trim().equals(""))
        {
            System.err.println("You entered a null file address.");
            return;
        }
        try 
        {
            //The below code will start reading to a file.
            Scanner line = new Scanner(new File(fileName));
            
            //This ensures that I'm reading the file in the appropriate way.
            //The following code also ensures that  I only capture what I want.
            int lastLine=0;
            while (line.hasNextLine()) 
            {
                lastLine++;
                String temp = line.nextLine();
                Scanner firstAndLast=new Scanner(temp);
                
                String last=firstAndLast.next();
                String first=firstAndLast.next();
                
                classRosterNames.add(first+" "+last);
                classRosterNames.trimToSize();
            }
            line.close();
            PeopleAtNDSU.container.add(classRosterNames);
            PeopleAtNDSU.container.trimToSize();
        } 
        catch (FileNotFoundException fnfe) 
        {
            discard=true;
            System.err.println("The file you entered doesn't exist.");
        }
        
    }
    
}
