/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Back__end;

import java.util.ArrayList;


public interface SearchResults<T> { //as there are two types of seaches groups and users Open-close
    //add search result to the list
    public void addSearchResult(T result);
    //get the list
    public  ArrayList<T> getSearchResults();
    //Search in database
    public void searchObjects (String searchAttempt);
    
}
