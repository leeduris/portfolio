/*
 * This game is a kind of Five Tic Tac Toe( Five Link game ).
 * To win the game, it should be first needed to link five 
 * the same color balls adjacently along the way of horizontal, 
 * vertical and diagonal directions. I used the skill of canvas 
 * element to make this game and refered to the w3schools tutorial.
 *
 * name: Sung Woo Lee(leeduris@gmail.com)
 * create date: Jan 29 2016
 * update date: Feb 04 2016
 */
 
// initiate the variable of game turn  
var BlueTurn = true; 

// set the variable of unit rectangular size to put a ball  
var lineNumber = 30;


// TODO 1: let the game ready at the window loaded
window.onload = function() 
{ 
   // TODO 1-1: invoke the playground to put the balls	
   strokeBoard(); 
   
   // TODO 1-2: invoke event handler at the click of canvas 
   document.getElementById("canvasGame").onclick = fillStone;
};

// TODO 2: draw the playground to put the balls
function strokeBoard() 
{ 
   // TODO 2-1: select the canvas elements               
   var canvasGame = document.getElementById("canvasGame");
   
   // TODO 2-2: create the context object to draw 
   var context = canvasGame.getContext("2d"); 
   
   // TODO 2-3: set the color of playground 
   context.fillStyle = "#d9c049";
   
   // TODO 2-4: set the size of playround then fill the color
   context.fillRect(0, 0, 580, 580);
   
   // TODO 2-5: draw the unit rectangulars in the playground to put a ball
   context.strokeStyle = "#333333"; 
   for(var x=20; x<=540; x+=lineNumber) {
      for(var y=20; y<=540; y+=lineNumber) { 
         context.strokeRect(x, y, lineNumber, lineNumber); 
      } 
   } 
}

// ODO 3: define the event handler to play game 
function fillStone(e) 
{ 
   // TODO 3-1: select the canvas element               
   var canvasGame = document.getElementById("canvasGame"); 
   
   // TODO 3-2: create the context object to draw 
   var context = canvasGame.getContext("2d"); 
   
   // TODO 3-3: began to draw 
   context.beginPath(); 
   
   // TODO 3-4: initiate the variable of ball coordinate 
   var x = 0; 
   var y = 0; 
   
   // TODO 3-5: calculate the ball coordinate at the clicked position. 
   var a = (e.offsetX-20) % lineNumber;  
   var b = (e.offsetY-20) % lineNumber;        
   x = e.offsetX - a;  
   y = e.offsetY - b; 
    
   
   /* TODO 3-6: draw the ball then put it at the its' coordinate.
	            store the color informations to check the existed ball 
				at a coordinate to put a new ball */
   var colorBack = context.getImageData(0, 0, 1, 1);
   context.arc(x+lineNumber/2, y+lineNumber/2, lineNumber/2, 0, 2*3.14);
   var colorPut = context.getImageData(x+lineNumber/2, y+lineNumber/2, 1, 1);
   
   // TODO 3-7: close the drawing
   context.closePath(); 
   
   // TODO 3-8: assign the turns of game player alternatively and fill the color 
   if( isSameColor(colorBack, colorPut) )
   {    
		if(BlueTurn) 
		{  
			context.fillStyle = "Blue"; 
			context.fill();	
			BlueTurn = false; 
		}
		else 
		{ 
			context.fillStyle = "Red";
			context.fill();
			BlueTurn = true; 
		}
	}
	
	else 
		alert("Put a ball at the empty place!");
   
   //context.fill();
   var colorPutted = context.getImageData(x+lineNumber/2, y+lineNumber/2, 1, 1);
	
   // TODO 4: Check whether 5 continuous balls have the same colors along 
   //   	  the way of vertical, horizontal or diagonal directitons  		
	isWinRow();
	isWinCol();
	isWinDiaP();
	isWinDiaN();
	
	// TODO 4-1: check the horizontal direction
	function isWinRow()
	{
		var count = 1;	
		for( var s=1; s>=-1; s-=2)
		{
			for( var i = s*lineNumber; Math.abs(i) <= lineNumber*4; i+=s*lineNumber) 
			{   
				if( x+i >= 20 && x+i <= 515 )
				{   
					var colorExist = context.getImageData( x+lineNumber/2 + i, y+lineNumber/2, 1 , 1);
					if( isSameColor(colorPutted, colorExist) )				
						count += 1;
		
					else break;
				}
			}
		}
	
		if(count >= 5) 
		{	if(BlueTurn)
				var winner = "Red Player";
			else 
				winner = "Blue Player";
				
			alert( winner + " Win!" );
			
			setTimeout( strokeBoard(), 1000 );
		}
	}
	
	// TODO 4-2: check the vertical direction
	function isWinCol()
	{
		var count = 1;	
		for( var s=1; s>=-1; s-=2)
		{
			for( var i = s*lineNumber; Math.abs(i) <= lineNumber*4; i+=s*lineNumber) 
			{   
				if( y+i >= 20 && y+i <= 515 )
				{   
					var colorExist = context.getImageData( x+lineNumber/2, y+lineNumber/2+i, 1 , 1);
					if( isSameColor(colorPutted, colorExist) )				
						count += 1;
		
					else break;
				}
			}
		}
	
		if(count >= 5) 
		{	if(BlueTurn)
				var winner = "Red Player";
			else 
				winner = "Blue Player";
				
			alert( winner + " Win!" );
			
			setTimeout( strokeBoard(), 1000 );
		}
	}
	
	// TODO 4-3: check the diagonal right direction
	function isWinDiaP()
	{
		var count = 1;
		for( var s=1; s>=-1; s-=2)
		{
			for( var i = s*lineNumber; Math.abs(i) <= lineNumber*4; i+=s*lineNumber) 
			{   
				if( x+i >= 20 && x+i <= 515 && y+i >= 20 && y+i <= 515 )
				{   var colorExist = context.getImageData( x+lineNumber/2+i, y+lineNumber/2-i, 1 , 1);
					if( isSameColor(colorPutted, colorExist) )				
						count += 1;
		
					else break;
				}
			}
		}
	
		if(count >= 5) 
		{	if(BlueTurn)
				var winner = "Red Player";
			else 
				winner = "Blue Player";
				
			alert( winner + " Win!" );
			
			setTimeout( strokeBoard(), 1000 );
		}
	}	
	
	//  TODO 4-4: check the diagonal left direction
	function isWinDiaN()
	{
		var count = 1;
		for( var s=1; s>=-1; s-=2)
		{
			for( var i = s*lineNumber; Math.abs(i) <= lineNumber*4; i+=s*lineNumber) 
			{   
				if( x+i >= 20 && x+i <= 515 && y+i >= 20 && y+i <= 515 )
				{   var colorExist = context.getImageData( x+lineNumber/2+i, y+lineNumber/2+i, 1 , 1);
					if( isSameColor(colorPutted, colorExist) )				
						count += 1;
		
					else break;
				}
			}
		}
	
		if(count >= 5) 
		{	if(BlueTurn)
				var winner = "Red Player";
			else 
				winner = "Blue Player";
				
			alert( winner + " Win!" );
			
			setTimeout( strokeBoard(), 1000 );
		}
	}	


	
}

// TODO 5: check whether the balls have the same color 
function isSameColor(imgDataP, imgDataQ) 
{
	if( imgDataP.data[0] == imgDataQ.data[0] &&
		imgDataP.data[1] == imgDataQ.data[1] &&
		imgDataP.data[2] == imgDataQ.data[2] )
				
		return true;
	
	return false;	
}

