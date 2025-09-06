/**
 * Problem: 355. Design Twitter
 * Difficulty: Medium
 * Approach: HashMap
 * Time: O(n), Space: O(n)
 */
class Twitter {

    public class User {
        Set<Integer> followers;
        ArrayList<Integer> feedList;
        ArrayList<Integer> myFeedList;
    }

    HashMap<Integer, User> userList;
    HashMap<Integer, Integer> feedReleseMap;
    Integer feedOrder;

    public Twitter() {
        userList = new HashMap<Integer, User>();
        feedReleseMap = new HashMap<Integer, Integer>();
        feedOrder = 0;
    }

    public void newUser(Integer userId) {
        User user = new User();
        user.followers = new HashSet<Integer>();
        user.feedList = new ArrayList<Integer>();
        user.myFeedList = new ArrayList<Integer>();
        userList.put(userId, user);
    }

    public void updateFeedList(Integer userId, Integer tweetId, Boolean isMyFeed) {
        User user = userList.get(userId);
        ArrayList<Integer> feedList = user.feedList;
        feedList.addFirst(tweetId);
        user.feedList = feedList;

        if (isMyFeed) {
            ArrayList<Integer> myFeedList = user.myFeedList;
            myFeedList.addFirst(tweetId);
            user.myFeedList = myFeedList;
        }

        userList.put(userId, user);
    }

    public void postTweet(int userId, int tweetId) {
        if (userList.size() == 0 || !userList.containsKey(userId)) {
            newUser(userId);
        }

        User user = userList.get(userId);
        Set<Integer> followers = user.followers;
        if (followers != null) {
            for (Integer followersId : followers) {
                updateFeedList(followersId, tweetId, false);
            }
        }

        updateFeedList(userId, tweetId, true);
        feedReleseMap.put(tweetId, feedOrder++);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (userList.containsKey(userId)) {
            User user = userList.get(userId);
            ArrayList<Integer> feedList = user.feedList;
            if (feedList.size() <= 10) {
                return feedList;
            } else {
                return feedList.subList(0, 10);
            }
        }

        return new ArrayList<Integer>();
    }

    public void follow(int followerId, int followeeId) {
        if (!userList.containsKey(followerId)) {
            newUser(followerId);
        }

        if (!userList.containsKey(followeeId)) {
            newUser(followeeId);
        }

        User followee = userList.get(followeeId);
        Set<Integer> followers = followee.followers;
        if (followers.contains(followerId)) {
            return;
        }

        followers.add(followerId);
        userList.put(followeeId, followee);

        User follower = userList.get(followerId);
        ArrayList<Integer> feedList = follower.feedList;
        ArrayList<Integer> myFeedList = followee.myFeedList;
        ArrayList<Integer> newFeedList = new ArrayList<Integer>();

        int i = 0;
        int j = 0;
        while (i < feedList.size() && j < myFeedList.size()) {
            if (feedReleseMap.get(feedList.get(i)) > feedReleseMap.get(myFeedList.get(j))) {
                newFeedList.add(feedList.get(i));
                i++;
            } else {
                newFeedList.add(myFeedList.get(j));
                j++;
            }
        }

        if (i < feedList.size()) {
            while (newFeedList.size() < 10 && i < feedList.size()) {
                newFeedList.add(feedList.get(i));
                i++;
            }
        }

        if (j < myFeedList.size()) {
            while (newFeedList.size() < 10 && j < myFeedList.size()) {
                newFeedList.add(myFeedList.get(j));
                j++;
            }
        }

        follower.feedList = newFeedList;
        userList.put(followerId, follower);
    }

    public void unfollow(int followerId, int followeeId) {
        User followeeUser = userList.get(followeeId);
        User followerUser = userList.get(followerId);

        if (!followeeUser.followers.contains(followerId)) {
            return;
        }

        ArrayList<Integer> followeeFeedList = followeeUser.myFeedList;
        ArrayList<Integer> feedList = followerUser.feedList;
        int i = 0, j = 0;
        while (i < feedList.size() && j < followeeFeedList.size()) {
            if (feedList.get(i) == followeeFeedList.get(j)) {
                feedList.remove(i);
                j++;
            } else {
                i++;
            }
        }

        followerUser.feedList = feedList;
        userList.put(followerId, followerUser);

        Set<Integer> followers = followeeUser.followers;
        followers.remove(followerId);
        followeeUser.followers = followers;
        userList.put(followeeId, followeeUser);
    }
}