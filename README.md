# BookClub
BookClub
Original App Design Project - README Template
===

# BookClub

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
BookClub is a platform where book-lovers can learn about new books to read based on their interests, keep track of their favorites, and connect with other readers.

### App Evaluation
- **Category:** Books
- **Mobile:** For convenience, this app will be primarily for moblie devices such as phones and tablets. It is meant to be accessible whenever the user desires.
- **Story:** This app displays a variety of books to users including different genres, recommendations, and trending books. Users can favorite books and view reviews and ratings from other users on each book. 
- **Market:** This app is can be marketed to avid book-lovers who want an organized platform to learn about more books and keep track of books they like as well as potentially connect with other book-lovers. It can also be for those who want to get more into reading.
- **Habit:** This app will be used as much as users would like to learn about more books and interact with others. It will ideally increase reading habits for those who desire it, but is not necessarily a habit-forming application. 
- **Scope:** In the beginning, the app will mostly be a way for readers to explore more reading options and track their own preferences as well as view others' opinions and express their own. Later, location services will be added for users to be able to see where certain books are read the most. Additionally more personal messaging features for readers to develop connections. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [x] User can create a new account with personal information and book preferences.
- [x] User can login to existing account
- [x] User can view the home page which will consist of currently trending books, recommended books for the user, and books categorized by genre.
- [] User will be able to click on any book to see a detail view of the book
- [] User will be able to use a search bar at the top of the screen to search for specific books.
- [x]  User will be able to navigate to all other screens from the homepage.
- [] Consists of the book title, author, summary, rating,and user reviews.   
- [] User will be able to write and post their own review.  
- [] User will be able to view and edit all pre-set profile information and book preferences.
- [] User will be able to view all their favorited books  
- [] User can unfavorite books from list
- []Tapping on book will lead to its detail view.  

**Optional Nice-to-have Stories**

* Location Services
    * Upon turning on location services, user will be able to view a map that displays book 'hotspots'. 
         * Hotspots (per book) show shaded locations based on density of users who read a specific book.
*  User will be able to follow others and view following and followers.
*  User will be able to direct message other users.
*  User can create and/or join Book-club messaging groups.

### 2. Screen Archetypes

* Login/Register Pages
    * User can create a new account with personal information and book preferences.
    * User can login to existing account
* Home Page
    * User can view the home page which will consist of currently trending books, recommended books for the user, and books categorized by genre.
    * User will be able to click on any book to see a detail view of the book
    * User will be able to use a search bar at the top of the screen to search for specific books.
    * User will be able to navigate to all other screens from the homepage.
* Book Detail View
    * Consists of the book title, author, summary, rating,and user reviews.   
    * User will be able to write and post their own review.  
* Profile Page
    * User will be able to view all pre-set profile information and book preferences.
    * User will be able to edit information.
*  Favorites List
    * User will be able to view all their favorited books  
    * User can unfavorite books from list
    * Tapping on book will lead to its detail view.  

### 3. Navigation

**Flow Navigation** (Screen to Screen)

* Login -> Homepage
* Register -> Homepage
* Homepage -> Search
* Homepage -> Profile
* Homepage -> Favorites List


## Wireframes

### [BONUS] Digital Wireframes & Mockups

<!--- <img src="https://github.com/Codepath-AAC/Bookclub-App/blob/main/Screen%20Shot%202022-03-29%20at%2010.32.15%20PM.png" width=600> --->
<!--- <img src="https://github.com/Codepath-AAC/Bookclub-App/blob/main/figma_photo.png" width=600 /> --->
<img src="https://github.com/Codepath-AAC/Bookclub-App/blob/main/proper_figma_photo.png" width=600 />

### [BONUS] Interactive Prototype

<!--- <img src='https://github.com/Codepath-AAC/Bookclub-App/blob/main/walkthrough_BookClub1.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' /> --->
<!--- <img src='https://github.com/Codepath-AAC/Bookclub-App/blob/main/figma_codepath_unit8-2022-03-29_23.40.24.gif' width='' alt='Video Walkthrough' /> --->
<!--- <img src='https://github.com/Codepath-AAC/Bookclub-App/blob/main/unit8_codepath_figma_demo-2022-03-29_23.50.37.gif' width='' alt='Video Walkthrough' /> --->
<img src='https://github.com/Codepath-AAC/Bookclub-App/blob/main/proper_proper_unit8_codepath_figma_demo.gif' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Schema 

### Models
User
| Property  | Type | Description |
| ------------- | ------------- | ------|
| username  | String  | username of the user | 
| name  | String  | name of the user |
| password | String | password of the user (hidden field) |
| profilePic | File | profile picture of the user |
| favoriteGenre | String | user's favorite book genre |

Book
| Property  | Type | Description |
| ------------- | ------------- | ------|
| bookname  | String  | name of the book | 
| author | String | name of the author |
| bookPic | File | book cover |
| genre | String | genre of book |
| rating | int | rating of the book |
### Networking
- Register Screen
   - (POST) create a new user
- Login Screen
   - (GET) gets user information
- Search Screen
   - (GET) get information on a book when looked up
- Main Screen
   - (GET) get information on top and recomended books for the user
- Book Screen
   - (GET) get all info regarding the book
   - (PUT) updates rating
- Profile Screen
   - (GET) Query logged in user object
   - (PUT) update user info
- Favorites Screen
   - (PUT) update the user's favorites list
- Messaging Screen
   - (GET) list of messages
- Location Screen
   - (GET) getting location data for all book readers
- Blog Screen
   - (POST) creating a blog post
   - (POST) creating a like on a post
   - (GET) reading other user's blog posts
   - (UPDATE) updating blog post data
   - (DELETE) deleting a blog post
- Direct Messaging Screen
   - (POST) creating a message
   - (GET) getting messages
   - (DELETE) deleting a message
- Comments Screen
   - (POST) creating a comment
   - (POST) creating a like on a comment
   - (GET) reading other user's comments
   - (UPDATE) updating a comment
   - (DELETE) deleting a comment
