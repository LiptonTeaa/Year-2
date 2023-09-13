module.exports = function(app, tempData) {
                                                                                                                                               
    // Handle our routes
    app.get('/',function(req,res){
        res.render('index.ejs');
    });                                  

    app.get('/start', function (req,res) {
        res.render('start.ejs');
    });                                             

    app.get('/login',function(req,res){
        res.render('login.ejs', tempData);
    });             

    app.post('/authenticateUser', (req, res) => {
        // Capture the input fields
        let username = req.body.username;
        let password = req.body.password;
        // Ensure the input fields exists and are not empty
        if (username && password) {
          // Execute SQL query that'll select the account from the database based on the specified username and password
          let sqlquery = "SELECT * FROM userinfo WHERE username = ? AND password = ?;";
          db.query(sqlquery, [username, password], (err, result, fields) => {
            // If there is an issue with the query, output the error
            if (err) throw err;
            // If the account exists
            if (result.length > 0) {
              // Authenticate the user
              req.session.loggedin = true; // Future Implementation 
              req.session.username = username;

              let data = Object.assign({}, tempData, {user:username});
              // Page to infrom the user of a successful login
              res.render('authenticateUser.ejs', data);
            } 
            else {
              // Will inform the user that their details are wrong
              res.render('incorrect.ejs');
            }
            res.end();
          }); 
        } else {
          // Will show if they try to login with empty fields
          res.render('empty.ejs');
          res.end();       
        }
      });

    app.get('/register', function (req,res) {
        res.render('register.ejs', tempData);
    });           

    app.post('/registering', function (req, res) {
        //saving in the database
        let sqlquery = "INSERT INTO userinfo (username, email, password) VALUES (?,?,?);";                                                                         
        // execute sql query
        let newrecord = [req.body.username, req.body.email, req.body.password];                                                                                       
        db.query(sqlquery, newrecord, (err, result) => {                                                                                       
                if (err) {                                                                                                                     
                        return console.error(err.message);
                }                                                                                                                              
                else
                //res.send(' The following user has been registered, user: '+ req.body.username + ' with email ' + req.body.email + ' and password ' + req.body.password);
                res.render('registering.ejs');
                });
    });                                                                                                                              

    app.get('/survey1',function(req,res){
        res.render('survey1.ejs', tempData);
    });            

    app.get('/survey2',function(req,res){
        res.render('survey2.ejs', tempData);
    });   

    app.get('/survey3',function(req,res){
        res.render('survey3.ejs', tempData);
    });             

    app.get('/account',function(req,res){
        res.render('account.ejs', tempData);
    });  

    app.get('/recommendations',function(req,res){
        res.render('recommendations.ejs', tempData);
    });  

    // Alternatively tested methods --------------

    //     //Search for user form handler
    //     app.get('/login', function (req, res) {
    //         //searching in the database
    //         let term = '%' + req.query.keyword + '%'
    //         let sqlquery = `SELECT *
    //                         FROM   userinfo 
    //                         WHERE  post_title LIKE ?`;
                                                                                                                                                   
    //         // Run the query
    //         db.query(sqlquery, [term, term], (err, result) => {                                                                                    
    //             if (err) {
    //                 res.redirect('./');
    //             }               
                            
    //         // Pass the results to the EJS page and view it
    //         // res.send('account.ejs', data);
    //         let data = Object.assign({}, forumData, {posts:result});                                                                                                           
    //         res.render('account.ejs', data);  
    //     });      
    // });                                                                                                                             
    
}  
