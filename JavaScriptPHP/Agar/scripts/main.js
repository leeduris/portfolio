/*   main.js

      main java script of bacteria game

      Author: Sung Woo Lee(leeduris@gmail.com)
      Created: 2016-02-06
      Updated: 2016-02-11
*/

// create a game piece class
function GamePiece( w, h, br, src, name)
{
     // public variables
     this.x = 0;                                // coordinates
     this.y = 0;
     this.vx = 0;                               // velocities
     this.vy = 0;
     this.width = w;                          // sizes
     this.height = h;
     this.borderRadius = br;             // border
     this.src = src;                           // image src
     this.className = name;            // class name( baccine/bacteria/food )
     this.score = 0;                          // score

     // private variables
     var el = null;                             // ref to game piece
     var scoreboard = null;               // ref to  scoreboard
     var img = null;                          // ref to image
     var self = this;                          // to this class instance
     var d = document;

     // initialize the game piece
     function init()
     {
          // lay out the image of game background
          document.body.style.backgroundImage = "url('images/backimg.jpg')";

          // create elements to contain the images of game piece
          img = d.createElement('img');
          imgBox = d.createElement('span');
          imgBox.appendChild(img);

          // create a element to contain image and scorebord
          el = d.createElement('div');

          // create elements to contain scorebord
          scoreboard = d.createElement('span');

          // assign class name to the game piece of baccine
          if(self.className == "baccine" )
                scoreboard.className = "sclass";

          // assign class name to the game piece of bacteria
           if(self.className == "bacteria" )
                scoreboard.className = "eclass";

           // append image to el element
           el.appendChild( imgBox );

           // append to the body element
           d.body.appendChild( el );

           // append scorebors element only if baccine and bacteria except food
           if(self.className == "baccine"  || self.className == "bacteria" )
                el.appendChild(scoreboard);

           // add a class/style/value
           img.src = self.src;
           el.className =  self.className;
           el.style.width = self.width + 'px';
           el.style.height = self.height + 'px';
           el.style.borderRadius = self.borderRadius + 'px';
           el.score = self.score;

           // set x/y variables of game pieces randomly
           self.x = window.innerWidth * Math.random()  ;
           self.y = window.innerHeight *  Math.random() ;

           // set vx/vy  variables of bacteria randomly
           if(self.className == "bacteria" )
           {
                self.vx =  Math.random() * 5  - 2;
                self.vy =  Math.random() * 5 - 2 ;
           }

          // listen for ticks and  move the game pieces
          el.addEventListener( 'tick', move );

     }   //  end of init()

     init(); // instantiate self

     // move the game pieces
     function move()
     {
           // move along the x/y axes using the velocity
          self.x += self.vx;
          self.y += self.vy;

          // check for boundaries
          var maxX = window.innerWidth - el.offsetWidth;
          var maxY = window.innerHeight - el.offsetHeight;
          if( self.x < 0 ) self.vx *= -1;
          if( self.y < 0 ) self.vy *= -1;
          if( self.x > maxX ) self.vx *= -1;
          if( self.y > maxY ) self.vy *= -1;

          // fix the coordinate of baccine game piece
          if(self.className != "baccine" )
          {
               el.style.top = self.y + 'px';
               el.style.left = self.x + 'px';
          }

          // mouse move event for baccine game piece
          document.onmousemove = mouse;
          function mouse(e)
          {
               if(self.className == "baccine" )
               el.style.left = e.clientX + 'px';
               el.style.top = e.clientY + 'px';
          }

      }   // end of move()


}  // end of  GamePiece function

// main function to run the game
function main()
{
     // sweep the existied container elements
     var container = document.querySelectorAll('.container');
     for(var i = 0; i < container.length; ++i)
          container[i].remove();

     // instance a baccine gamepiece
     new GamePiece(20, 20, 10, "images/1.png", "baccine");

     // instance a food game piece
     for( var i=0; i<40; ++i )
          new GamePiece(30, 30, 15, "images/food.png", "food");

    // instance bacteria game pieces
     for( var i=0; i < 5; ++i )
     {
          new GamePiece(50, 50, 25, "images/2.png", "bacteria");
          new GamePiece(50, 50, 25, "images/3.png", "bacteria");
          new GamePiece(60, 60, 30, "images/4.png", "bacteria");
          new GamePiece(60, 60, 30, "images/5.png", "bacteria");
          new GamePiece(70, 70, 35, "images/6.png", "bacteria");
          new GamePiece(70, 70, 35, "images/7.png", "bacteria");
          new GamePiece(80, 80, 40, "images/8.png", "bacteria");
     }

     // run the game
     run();

}    // end of main() function

// this function will run every ~60 frames
function run()
{
     // listen keydown(esc key) event to stop invoking time function
     window.addEventListener('keydown', function (e)
     {
          if( e.keyCode == 27 )      // esc key
          {
               // stop animation frame
               cancelAnimationFrame( t );

               // print
               console.log("canceled");
          }
     });

     // create tick event to make game pieces move
     var tick = new Event('tick');

     // find all the GamePieces
     var food= document.querySelectorAll('.food');
     var bacteria= document.querySelectorAll('.bacteria');
     var baccine= document.querySelectorAll('.baccine');
     var sclass = document.querySelectorAll('.sclass');
     var eclass = document.querySelectorAll('.eclass');

     // dispatch food game pieces
     for( var i = 0; i < food.length; i++ )
          food[i].dispatchEvent( tick );

     // dispatch bacteria game pieces
     for( var i  = 0; i < bacteria.length; i++ )
          bacteria[i].dispatchEvent( tick );

     // dispatch baccine game pieces
          baccine[0].dispatchEvent ( tick );

     // judge the time of collision between all game pieces each other
     for( var j=0; j<food.length; j++ )
     {
           // check the time of collision between the game pieces of food and baccine
           if( collision(baccine, food, 0, j) )
           {
               // delete food game piece
               food[j].remove();

               // score up baccine game piece and display the score
               baccine[0].score += 5;
               sclass[0].innerText =  "Score " + baccine[0].score;

               // add style of score element
               sclass[0].style.width = "80px";
               baccine[0].style.fontSize = "medium";
               baccine[0].style.color = "tomato";

               // supply food game piece
               new GamePiece(30, 30, 15, "images/food.png", "food");
          }

          for( var i=0; i<bacteria.length; i++ )
          {
                // check the time of collision between the game pieces of food and bacteria
                if( collision(bacteria, food, i, j) )
                {
                     // delete food game piece
                    food[j].remove();

                    // score up bacteria game piece and display the score
                    bacteria[i].score += 20;
                    eclass[i].innerText =  bacteria[i].score;

                    // supply food game piece
                    new GamePiece(30, 30, 15, "images/food.png", "food");
                }

                // check the time of collision between the game pieces of baccine and bacteria
                if( collision(bacteria, baccine, i, 0) )
                {
                     // check each scores between the game pieces of baccine and bacteria
                     // if bacteria has more bigger score than baccine's
                     if(bacteria[i].score > baccine[0].score)
                     {
                          // delete baccine game piece which means game end
                          baccine[0].remove();

                          // ask an opinion to continue the game
                          var gameAgain = confirm("Continue ?");

                          // if want
                          if ( gameAgain )
                          {
                               // sweep all div elements for new game
                                var clear = document.querySelectorAll('div');
                                for(var i = 0; i < clear.length; ++i)
                                     clear[i].remove();

                               // start a new game
                                main();
                          }

                                // if quit
                          else
                               // go to main page
                               window.open('index.html', '_self');
                     }

                     // if baccine has more bigger score than bacteria's
                     else
                     {
                          // delete bacteria game piece
                          bacteria[i].remove();

                          // score up baccine game piece and display the score
                          baccine[0].score += 5;
                          sclass[0].innerText =  "Score " + baccine[0].score;
                     }

                }
           }
      }

     var t = requestAnimationFrame( run );

}   // end of run() function

// retuen true if there is a collision
function collision(a, b, i, j)
{
      // set center position of two game pieces a, b
      var center_ax = a[i].offsetLeft + a[i].offsetWidth/2;
      var center_ay = a[i].offsetTop + a[i].offsetHeight/2;
      var center_bx = b[j].offsetLeft + b[j].offsetWidth/2;
      var center_by = b[j].offsetTop + b[j].offsetHeight/2;

      // set the distance between two game pieces a, b
      var diff =  a[i].offsetWidth/4 + b[j].offsetWidth/4;

      // calculate the distances to make collision
      var distance_x = Math.abs( center_ax - center_bx );
      var distance_y = Math.abs( center_ay - center_by );

      // true if two game pieces come into the area of collision
      var yn = (distance_x < diff && distance_x > 0 && distance_y < diff && distance_y > 0);

      // make game piece's size bigger at the time of collision
      if( (a[i].className == "bacteria" || a[i].className == "baccine") && yn==true)
      {
               a[i].style.width = parseFloat(a[i].style.width) + 2 + 'px';
               a[i].style.height = parseFloat(a[i].style.height) + 2 + 'px';
               a[i].style.borderRadius = parseFloat(a[i].style.borderRadius) + 1 + 'px';
      }

      return yn;
}
