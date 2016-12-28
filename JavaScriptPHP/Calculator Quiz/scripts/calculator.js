/*
 * This is to define the functions and make some 
 * executions for calculator and searching process.
 * 
 * name: Sung Woo Lee(leeduris@gmail.com)
 * create date: Feb 14 2016
 * update date: Feb 17 2016
 */


// behaviours for search form

function search() {
    var form = document.getElementById('searchF');

    // assign the search engine for the checked option
    if (form.engine[0].checked) {
        form.action = "https://www.google.ca/search";
    } else if (form.engine[1].checked) {
        form.action = "https://www.facebook.com/srch.php";
    } else {
        form.action = "https://www.sheridancollege.ca/about/search-Results.aspx";
    }
}

// behaviours for drop list section form

// create the event hander to change the border image 
document.querySelector('#sel').addEventListener("change", selectFunction);

// function to assign the border image attribute to border object
function selectFunction() 
{
    // array to contain the borderImageRepeat attribute
    var arrBorder = ["round", "stretch", "repeat", "initial"];

    // select the border object
    var borderImage = document.querySelectorAll('.border')[0];
    
    // select the select element
    var sel = document.querySelector('#sel');
    
    // change the selected option to assign the borderImageRepeat attribute
    for(var i = 0; i < sel.options.length; ++i)
    {
      if(sel.options[i].selected)
      {
        /* Code for Safari 5 */
        borderImage.style.WebkitBorderImage = "url(images/border.png) 30 30 " + arrBorder[i];

        /* Code for Opera 12 */  
        borderImage.style.OBorderImage = "url(images/border.png) 30 30 " + arrBorder[i];
    
        borderImage.style.borderImage = "url(images/border.png) 30 30 " + arrBorder[i];
      }
    }
}


// behaviours for calculator form

// set the size of buttons of the calculator
var lineSpace = 60;

// design the shape of calculator  
window.onload = function() 
{
      // variable to give numeric values to each number buttoms 
      var num = 1

      // instance the object of border
      new buttonSet(-0.1, -0.8, 11, 7, "", "border", 0);

      // instance the ojects of number buttons
      for(var i = 3; i >= 1; --i)
      {
            for(var j = 1; j <= 3; ++j)                        
            {
                  new buttonSet(j, i, 1, 1, "images/" + num + ".png", 
                                "number", num);
                  ++num;
            }
       }

       // variable to assign image name to each operator buttons 
       var  operator =  ["divide", "multiply", "minus", "plus",  
                         " / ", " * ", " - ", " + "];
       
       // instance the objects of operator buttons
       for(var i = 1; i <= 4; ++i)
       {
            new buttonSet(4, i, 1, 1, "images/" + operator[i-1] + ".png", 
                          "operator", operator[i+3]);
       }

       // instance the objects of other buttons
       new buttonSet(1, 4, 1, 1, "images/0.png", "number" , 0);
       new buttonSet(3, 4, 1, 1, "images/equal.png", "equal" , "=");
       new buttonSet(2, 4, 1, 1, "images/clear.png", "clear", "" );
       
       // instance the object to show the numeric expression on user input 
       new buttonSet(1, 0, 4, 1, "", "display" , "");

       // instance the object to show the quiz to solve the problem above
       new buttonSet(6, 1, 4, 3, "", "quiz" , "");

       // instance the object to write the title of quiz board 
       new buttonSet(6, 0, 4, 1, "", "title" , "Which One is Corrent ?");

       // instance the object to show the score of right answers
       new buttonSet(6, 4, 4, 1, "", "score" , 0);

       // initiate the display object
       document.querySelectorAll('.display')[0].innerHTML = 0;

}


// define and make the object template of a button
var buttonSet = function(r, c, w, h, src, name, value)
{
      // public variables
      this.lineSpace = 60;      // container size of button image
      this.row = r;             // row position of a button 
      this.column = c;          // column position of a button  
      this.width = w;           // width of a button image
      this.height = h;          // height of a button image
      this.src = src;           // url of a button image
      this.className = name;    // class name of a button
      this.value = value;       // value of a button

      // private variables
      var self = this;          // to this class instance

      // select the element to draw calculator canvas              
      var box = document.getElementById('box');             

      // create elements to contain the images of button piece
      var img = document.createElement( 'img' );    
      var imgBox = document.createElement( 'div' );
      imgBox.appendChild( img );

      // append button images to canvas
      box.appendChild( imgBox );

      // add attribute
      img.src = self.src;  
      imgBox.className = self.className;
      imgBox.value = self.value;
      imgBox.style.backgroundColor = "#F0F8FF";
      imgBox.style.width = self.lineSpace + "px"; 
      imgBox.style.height = self.lineSpace + "px";
      imgBox.style.borderRadius = self.lineSpace*0.5 + "px";

      // add style to display object
      if(imgBox.className == "display")
      {
          imgBox.style.borderRadius = 0;
          imgBox.style.textAlign = "right";
          imgBox.style.paddingRight = "12px";
          imgBox.style.paddingTop = "12px";
          imgBox.style.fontSize = "x-large";
          imgBox.style.color = "#FF0000";
          imgBox.style.border = "#00FF00 solid 1px";
      }

      // add style to quiz object
      if(imgBox.className == "quiz")
      {
          imgBox.style.borderRadius = 0.2;
          imgBox.style.textAlign = "left";
          imgBox.style.paddingRight = "12px";
          imgBox.style.paddingTop = "12px";
          imgBox.style.fontSize = "large";
          imgBox.style.color = "#FF0000";
          imgBox.style.border = "#00FF00 solid 1px";
      }

      // add style to title object
      if(imgBox.className == "title")
      {
          imgBox.style.borderRadius = 0.1;
          imgBox.style.textAlign = "center";                
          imgBox.style.paddingTop = "15px";
          imgBox.style.fontSize = "large";
          imgBox.style.color = "#FF00FF";
          imgBox.style.border = "#005522 solid 1px";
          imgBox.innerHTML = imgBox.value;
      }

      // add style to score object score
      if(imgBox.className == "score")
      {
          imgBox.style.borderRadius = 0.1;
          imgBox.style.textAlign = "center";                
          imgBox.style.paddingTop = "15px";
          imgBox.style.fontSize = "large";
          imgBox.style.color = "#EE8899";
          imgBox.style.border = "#0055EE solid 1px";
          imgBox.innerHTML = "Your Score: " + imgBox.value; 
      }

      // add border image style to the border object
      if(imgBox.className == "border")
      {
          imgBox.style.border = "15px solid transparent";  
      }

      // calculate the button coordinate at given position 
      var x = 100 + self.lineSpace * self.row ;  
      var y = 200 + self.lineSpace * self.column;
      imgBox.style.left = x + "px";
      imgBox.style.top = y + "px";

      // set the size of button
      imgBox.style.width = self.width * self.lineSpace + "px";
      imgBox.style.height = self.height * self.lineSpace + "px";  

      // define event function on the button click
      imgBox.addEventListener("click", function()
      {     
          // select the objects to show the button event
          var display = document.querySelectorAll('.display');
          var quiz = document.querySelectorAll('.quiz');              
          
          // delete the existiing expression on the click of clear button
          if(imgBox.className == "clear")         
          {         
                display[0].value = imgBox.value;                           
          }         

          else
          {    
              // calculate the numeric expression on the click of equal button
              if(imgBox.className == "equal")   
              {     

                // variable to contain the radio form script for quiz
                var beginTag = '<div class="radio">' +  
                               '<label><input type="radio" class="inputCal">';

                var endTag = '</label></div>';   

                // calculate to result the quiz
                var ans = eval(display[0].value).toFixed(4); 

                // array to contain the values of radio button selection
                var arr = [(ans-3).toFixed(4), 
                           (ans-2).toFixed(4), 
                           (ans-1).toFixed(4)];

                // variable of answer index randomly            
                var ram = Math.floor(Math.random()*3);
                arr[ram] = ans;

                // variable to write the script of the radio form 
                var newQuiz = '<div class="container">';
                newQuiz += '<form role="form">';

                for(var i = 0; i < 3; ++i)
                    newQuiz += beginTag + arr[i] + endTag;

                newQuiz += '<input type="button" value="Ans" class="inputCal">';  
                newQuiz += '</form>';
                newQuiz += '</div>';

                // insert the script into the quiz object
                quiz[0].innerHTML = newQuiz;

                // assign the mutiful choice answers to the quiz selection
                var input = document.querySelectorAll('.inputCal');
                for(var i = 0; i < input.length-1; ++i)
                {
                    input[i].setAttribute("value", i);
                }

                // calculate the score on the click of submit button
                input[input.length-1].onclick = 
                function()  
                {
                    // select score object to show the score
                    var score = document.querySelectorAll('.score');

                    // look for the ckecked radio button
                    var form = document.forms[0];
                    var i;                          
                    for (i = 0; i < form.length; i++) 
                    {               
                        // with correct the answer               
                        if (form[i].checked && form[i].value == ram) 
                        { 
                          alert("Correct Answer");
                          score[0].value += 10;
                          break;
                        } 

                        // with wrong answer
                        if(i==form.length-1)
                            alert("Wrong Answer");   
                    }

                    // update the score
                    score[0].innerHTML = "Your Score: " + score[0].value;      
                }
              }

              // keep writing the values of user input data until equal button click   
              else
                display[0].value += imgBox.value;
          }

          // show the expression on the dispaly object
          display[0].innerHTML = display[0].value;
      });

      // add button style to mouse event
      imgBox.onmouseover = function()
      {
        if(imgBox.className == "number")
              imgBox.style.backgroundColor = "#F0F800";

        if(imgBox.className == "operator")
              imgBox.style.backgroundColor = "#00F8FF";

        if(imgBox.className == "clear")
              imgBox.style.backgroundColor = "#FF0000";

        if(imgBox.className == "equal")
              imgBox.style.backgroundColor = "#00FF00";
      }

      imgBox.onmouseout = function()
      {
              imgBox.style.backgroundColor = "#F0F8FF";  
      }   

      // add border image stype to dropbox list event

      document.querySelector('#sel').addEventListener                 

} 
