
package Back__end;

import java.util.ArrayList;


public class UserSearchResults implements SearchResults<User> {
    //manages search results
    private ArrayList<User> searchResults = new ArrayList<>();
    @Override
    public void addSearchResult(User result) {
       searchResults.add(result);
    }

    @Override
    public ArrayList<User> getSearchResults() {
        return searchResults;
    }

    @Override
    public void searchObjects(String searchAttempt) {
        searchResults.clear();
        UserRepository.loadUsersFromJson();
        for (User user : UserRepository.userList) {
            if (user.getUsername().toLowerCase().contains(searchAttempt.toLowerCase())) {
                addSearchResult(user);
            }
        }
    }
}

