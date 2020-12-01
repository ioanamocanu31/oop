# Homework - VideosBD

// Object Oriented Programming Course
// Mocanu Ioana - 321 CD
// 1 December 2020
// Git repo : https://github.com/ioanamocanu31/oop


# Info
https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/tema

# About the database
    For the database I just added the necessary variables/ methods in the classes from the packages src/fileio and
src/entertainment.

# About the tasks
    For solving the task I made the package actions.
* command
    Command - the class that gather all the commands together
            - this is the one used in the main for all the command actions
    Favorite - adds a video to a certain user's favorite video list
            - it implements the cases when the user did not see the movie, when the video was already in the favorite
            list and when the video was successfully added to the list
            - this action is achieved from the Command class in main
    Rating - gives a rating to a show
            - it is implemented for movies and for serials differently
            - it got the error cases: show was already rated or the show was not seen and the success case
            - *problems* in this task I could not managed to also calculate the rating for the movie and for the serial.
            I have implemented the methods but could not apply them, that is why the MovieInputData movieRating field
            never accessed, but assigned in the method calculateRating()
            - this action is achieved from the Command class in main
    View - marks a video as seen
         - if the video was already seen the key in the History is just replaced with a incremented value
         - this action is achieved from the Command class in main

* query
    * actor
        Awards -
                - this action is achieved from the Query class in main

    * user - I did not managed to solve these actions
    * video - all these actions are achieved from the Query class in main
        Favorite -
        Longest -
        MostViewed -
        Rating -
    Query - the class that gather all the queries together
          - this is the one used in the main for all the queries actions

* recommendation
    * all - actions for all types of users
        Standard - gets the first unseen video
                - this action is achieved from the Recommendation class in main
    * premium - actions for the premium users
        Favorite - the most frequently found show in the favorite list
                - this action is achieved from the Recommendation class in main

        Search - all unseen videos with a certain filter
                - this action is achieved from the Recommendation class in main

    Recommendation - the class that gather all the recommendation together
                   - this is the one used in the main for all the recommendation actions
# About the main/Main
    I traversed all actions and checked what type it was and the user it applies to. Then for each case I called the
proper class for that action from the actions package.

# About the constants
    I used my own constants declared in the common/Constants class beside the Strings.

# About the inspiration
    I used these links to cover the Collections issues.
[1] https://www.geeksforgeeks.org/hashmap-replacekey-value-method-in-java-with-examples/
[2] https://www.geeksforgeeks.org/stringbuilder-append-method-in-java-with-examples/
[3] https://www.codebyamir.com/blog/how-to-use-a-map-in-java
[4] https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/#processing-order
[5] https://www.baeldung.com/java-hashmap-sort
[6] https://stackoverflow.com/a/10462838
[7] https://www.baeldung.com/java-hashmap-sort