// Import the modules we need
var express = require ('express')
var ejs = require('ejs')
var bodyParser= require ('body-parser')
const mysql = require('mysql');

// For the login system
const session = require('express-session');

// Create the express application object
const app = express()
const port = 8000 
app.use(bodyParser.urlencoded({ extended: true }))  
// should make using images and css easeir
app.use('/images', express.static("images"));         
app.use('/css', express.static("css"));   

// For the login system
app.use(session({
        secret: 'secret',
        resave: true,
        saveUninitialized: true
    }));
                                                                                                                                               
// Define the database connection
const db = mysql.createConnection ({
                                                                                                                                               
        host: 'localhost',
        user: 'root',
        password: 'ILoveBread',
        database: 'skincare'
});                                                                                                                                            
                                                                                                                                               
// Connect to the database
db.connect((err) => {                                                                                                                          
        if (err) {
                throw err;
        }                                                                                                                                      
        console.log('Connected to database');
});                                                                                                                                            
global.db = db;                                                                                                                                
                                                                                                                                               
// Set the directory where Express will pick up HTML files
// __dirname will get the current directory
app.set('views', __dirname + '/views');

// Tell Express that we want to use EJS as the templating engine
app.set('view engine', 'ejs');
                                                                                                                                               
// Tells Express how we should process html files
// We want to use EJS's rendering engine
app.engine('html', ejs.renderFile);
                                                                                                                                               
// Define our data, I thought we could use this for our survey answers. It is currently used for login data.
var tempData = { surveyOne: "oily",
surveyTwo:"acne", surveyThree:"dry"}
                                                                                                                                               
// Requires the main.js file inside the routes folder passing in the Express app and data as arguments.  All the routes will go in this file
require("./routes/main")(app, tempData);
                                                                                                                                               
// Start the web app listening
app.listen(port, () => console.log(`Example app listening on port ${port}!, press ^C to terminate.`))  
