/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopleatndsu;

/**
 *
 * @author Owner
 */
public class Person 
{
    /*
    This class will make a object that represents a person, I should be able
    to tell what major they are in, how many times (and at what time) the student
    may have made the deans list. I should also take in their name, title,
    and year in school.
    
    I believe that I should be taking a string list for the years that the person
    may have made the deans list. I do believe that I will use ArrayLists for this
    task, but I have to be careful to trim them before I set the up into my searchable 
    array.
    
    I think I may be able to implement a historical feature somewhere down the line.
    The historical feature could be as simple as text files that were different.
    */
    
    public String name="";
    public String title="";
    public String major="";
    public String year="";
    public String deansList="";
    public String commonClass="";
    
    public Person()
    {
        name="NA";
        title="NA";
        major="NA";
        year="NA";
        deansList="NA";
        commonClass="NA";
    }
    
    //I may need to make some setters simply to enable additions to someone's "profile"
    public void setTitle(String title)
    {
        this.title=title;
    }
    
    public void setMajor(String major)
    {
        this.major=major;
    }
    
    public void setYear(String year)
    {
        this.year=year;
    }
    
    public void setCommonClass(String commonClass)
    {
        this.commonClass=commonClass;
    }
    
    public void setDeansList(String deansList)
    {
        this.deansList=deansList;
    }
    
    public void setName(String name)
    {
        this.name=name;
    }
    
    public String getCommonClass()
    {
        String dummie=commonClass;
        return dummie;
    }
    
    public String getName()
    {
        String dummie=name;
        return dummie;
    }
    
    public String getTitle()
    {
        String dummie=title;
        return dummie;
    }
    
    public String getMajor()
    {
        String dummie=major;
        return dummie;
    }
    
    public String getYear()
    {
        String dummie=year;
        return dummie;
    }
    
    public String getDeansList()
    {
        String dummie=deansList;
        return dummie;
    }
    
    public boolean equals(Person p)
    {
        return this.getName().equals(p.getName());
    }
    
    public String toString()
    {
        String returned="Name: "+this.getName()+" Title: "+this.getTitle()+" Major: "+this.getMajor()
                +" Year: "+this.getYear()+" Common Class: "+this.getCommonClass()+" Deans List: "+ this.getDeansList();
        return returned;
    }
    
    
}
