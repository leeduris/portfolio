/*
 * create 3 types of card display motion functions
 * and a bulb flash function then give some effects 
 * of animation in each card motions   
 * name: Sung Woo Lee(leeduris@gmail.com)
 * create date: Jan 22 2016
 * update date: Jan 28 2016
 */

function cardMove()

	// select card image boxes to be contained each card images 
{   var cardElements = document.getElementsByClassName('cardbox');
	
	// first card motion to divide 24 cards into 6 cards to each directions for each assumed card player 
    var fsign = [-1, 0, 1, 0, -1];
    function firstMove(i)
    {   
		// set each cards' destination locations from their current positions
		cardElements[i].style.top = parseFloat( cardElements[i].style.top )  + fsign[i%4] * 200 + 'px';
        cardElements[i].style.left = parseFloat( cardElements[i].style.left )  + fsign[i%4+1] *350 + 5*i + "px";
        
		// recursive function then put a time delay to make effect on each execution loop  
		if( i < cardElements.length-2) setTimeout( function() { firstMove(i+1); }, 700 );
    }

	// second card motion to make above 4 players' cards relocate to 4 directions' corners in the container 
    var ssign = [0, 1, 0, -1, 0];
    function secondMove(i)
    {   
		// set each cards' destination locations from their current positions
		cardElements[i].style.top = parseFloat( cardElements[i].style.top ) + ssign[i%4] * 200 + 'px';
        cardElements[i].style.left = parseFloat( cardElements[i].style.left ) + ssign[i%4+1] *350 + 2*i + "px";
        
		// recursive function then put a time delay to make effect on each execution loop  
		if( i < cardElements.length-2) setTimeout( function() { secondMove(i+1); }, 100 );
    }

	// third card motion to display tracing card movement during going to destination position 
    function thirdMove()
    {   
		// make time interval effect 
		var animate = setInterval( frame, 20 );
		
		// make a unit frame to be called in each time interval   
		var pos = [0, 0.05, 0.1, 0.15, 0.2, 0.25];        
        function frame()
        {   
			for( var i = 0; i < cardElements.length-1; i++ )
            {   
				// divide each cards' destination into 4 directions 
				switch ( i%4 )
                {   
					// set cards of going to north direction 
					case 0:
                        // stop animation at the destination location
						if( parseFloat( cardElements[i].style.top ) <= window.innerHeight/20)
                            clearInterval( animate );
                        // give a movement of a tiny step by step 
						else
                        {   
							cardElements[i].style.top = parseFloat( cardElements[i].style.top ) - 1 + "px";
                            cardElements[i].style.left = parseFloat( cardElements[i].style.left ) + pos[Math.floor( i/4 )] + "px";
                        }
                        break;
                    // set cards of going to east direction 
					case 1:
						// stop animation at the destination location
						if( parseFloat( cardElements[i].style.left ) >= window.innerWidth/1.5 )
                            clearInterval( animate );
                        // give a movement of a tiny step by step 
						else
                        {   
							cardElements[i].style.left = parseFloat( cardElements[i].style.left ) + 1 + "px";
                            cardElements[i].style.left = parseFloat( cardElements[i].style.left ) + pos[Math.floor( i/4 )] + "px";
                        }
                        break;
					// set cards of going to south direction	
                    case 2:
                        // stop animation at the destination location
						if( parseFloat( cardElements[i].style.top ) >= window.innerHeight/1.5)
                            clearInterval( animate );
                        // give a movement of a tiny step by step 
						else
                        {   
							cardElements[i].style.top = parseFloat( cardElements[i].style.top ) + 1 + "px";
                            cardElements[i].style.left = parseFloat( cardElements[i].style.left ) + pos[Math.floor( i/4 )] + "px";
                        }
                        break;
					// set cards of going to west direction	
                    case 3:
						// stop animation at the destination location
                        if( parseFloat( cardElements[i].style.left ) <= window.innerWidth/50 )
                            clearInterval( animate );
                        // give a movement of a tiny step by step 
						else
                        {   
							cardElements[i].style.left = parseFloat( cardElements[i].style.left ) - 1 + "px";
                            cardElements[i].style.left = parseFloat( cardElements[i].style.left ) + pos[Math.floor( i/4 )] + "px";
                        }
                        break;
                }
            }
        }
    }

	// function to flash bulbs
	// select flash bulbs and make arrays to give them colors and texts
    var fboxElements = document.querySelectorAll('.bulb');
    var text = ["CARD", "", "GAME", "", "FUN", ""]
    var color = ["LightSteelBlue", "Bisque", "Gainsboro", "PaleGoldenRod", "Lavender", "cyan", "Thistle", "Cornsilk", "Beige"];
    function flash(i)
    {   
		// randomly select flash bulb then set its' color, text and so on 
		var fl = fboxElements[parseInt( Math.random()*fboxElements.length )];
        fl.style.background = color[i%9];
        fl.innerText = text[i%6];
        fl.style.color = "black";
        fl.style.fontSize = "xx-large";
		fl.style.textAlign = "center";
        
		// make a effect to give display time delay at each recursions 
		if( i < 5000 ) setTimeout( function() { flash(i+1); }, 100 );
    }

	// set the order to execute each functions in turn 
    firstMove(0);
    setTimeout( function() { secondMove( 0 ); }, 20000);
    setTimeout( cardSuffle, 27000);
    setTimeout( thirdMove, 27500);
    flash(0);
	
} 