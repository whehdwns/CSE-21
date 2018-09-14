
public class Student {
 
    public String Name; 
    public char Gender; 
    public int Month; 
    public int Day; 
    public int Year; 
    Date birthDay = new Date (); 
    Preference pref;  
    public boolean matched; 
 
    public Student () { 
    Name = ""; 
    Gender = 'M'; 
    matched = false; 
    birthDay = new Date (Month, Day, Year); 
 
    } 
 
    public Student (String Name, char Gender, boolean matched, Preference pref) { 
    this.Name = Name; 
    this.Gender = Gender; 
    this.matched = matched; 
    birthDay = new Date ( Month, Day, Year); 
    this.pref = pref; 
    } 
 
    public void setGender (char Gender) { 
    this.Gender = Gender; 
    } 
 
 
    public void setBirthDay ( int Month, int Day, int Year){ 
    birthDay = new Date (Month, Day, Year); 
    } 
 
    public void setMatched (boolean matched){ 
    this.matched = matched; 
    } 
 
    public void setPref(Preference pref){
    this.pref = pref;
    }
 
    public char getGender () { 
    return this.Gender; 
    }
    public int Compatibility(Student st ){ 
        int score = 0; 
        int preference = Math.abs(pref.Compability (st.pref)); 
        int AgeDifference = Math.abs(birthDay.compare(st.birthDay)); 
        if (this.Gender != st.getGender()){ 
        score = 0; 
        } 
        else { 
        score = (40 - preference) + (60 - AgeDifference); 
 
        } 
        return score; 
 
        }
}
 