class Twitter {
    //first we need a global timestamp 
    private static int timestamp = 0;

    //we need a map to link the user class with the userId
    Map<Integer, User> users = new HashMap<>();

    private class Tweet{
        public int id;
        public int time;
        public Tweet next; //linked list head;

        public Tweet(int id){
            this.id = id;
            next = null;
            time = timestamp++;
        }
    }

    private class User{
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id){
            this.id = id;
            followed = new HashSet<>();
            follow(id); //user should follow themselves to see their posts
            tweetHead = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }

        public void post(int tweetId){
            Tweet t = new Tweet(tweetId);
            t.next = tweetHead; // we have to add tweets to the front of linked list
            tweetHead = t; 
        }
    }

    public Twitter() {
        users = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)){
            User user = new User(userId);
            users.put(userId, user);
        }

        users.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new LinkedList<>();

        if(!users.containsKey(userId)) return list;

        Set<Integer> followers = users.get(userId).followed;

        PriorityQueue<Tweet> pq = new PriorityQueue<>(followers.size(), (a, b) -> (b.time - a.time));

        for(int followee: followers){
            Tweet t = users.get(followee).tweetHead;

            if(t != null){
                pq.add(t);
            }
        }

        int count = 0;

        while(!pq.isEmpty() && count<10){
            count++;
            Tweet t = pq.poll();
            list.add(t.id);

            if(t.next != null){
                pq.add(t.next);
            }
        }

        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        // we have to check if both follower and followee exists and then follow

        if(!users.containsKey(followerId)){
            User user = new User(followerId);
            users.put(followerId, user);
        }
        if(!users.containsKey(followeeId)){
            User user = new User(followeeId);
            users.put(followeeId, user);
        }

        users.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId) || followerId == followeeId) return;

        users.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */