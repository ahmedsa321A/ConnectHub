
package Back__end;

import java.util.ArrayList;


public class GroupSearchResults implements SearchResults<Group>  {

    private ArrayList<Group> searchResults = new ArrayList<>();
    @Override
    public void addSearchResult(Group result) {
        searchResults.add(result);
    }

    @Override
    public ArrayList<Group> getSearchResults() {
        return searchResults;
    }

    @Override
    public void searchObjects(String searchAttempt) {
        searchResults.clear();
        GroupDatabase.loadGroupsFromJson();
        for (Group group : GroupDatabase.getGroups()) {
            if (group.getName().toLowerCase().contains(searchAttempt.toLowerCase())) {
                addSearchResult(group);
            }
        }
    }
  }
    
