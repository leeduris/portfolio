/*
 * create div elements to contain card images and flash bulbs
 * and place them on the screen in given locations and select 
   24 cards randomly to shuffle them then get ready to game
 * name: Sung Woo Lee(leeduris@gmail.com)
 * create date: Jan 22 2016
 * update date: Jan 28 2016
 */
 
function cardSuffle()
{   
	// select card images classes         
	var clearcard = document.getElementsByClassName('cardbox');
    
	// select flash bulb classes
	var clearfbox = document.querySelectorAll('.bulb');

	// clear existing div elements to begin a new game
    for( var i = clearcard.length-1; i >= 0; i-- )
    {   
		clearcard[i].remove();
        clearfbox[i].remove();
    }

	// make array with 54 indexes later to use for card image names
    var src = [];
    for ( var i = 0; i < 54; i++  )
    {   
		src[i] = i + 1;
    }

	// shuffle array indexes  
    for ( var i in src  )
    {   
		var index = Math.floor( Math.random()*src.length );
        var temp = src[index];
        src[index] = src[i];
        src[i] = temp;
    }

	// base layer container's width and heigth to locate cards and flashs 
    var w = document.querySelector( '#container' ).clientWidth;
    var h = document.querySelector( '#container' ).clientHeight;

    // create one bulb div then assign its' class name and size
	var bulb = document.createElement( "div" );
    bulb.className = "bulb";
    bulb.style.position = "absolute";
    bulb.style.width = w/5 + "px";
    bulb.style.height = h/5 + "px";

    var fbox = [];     // array to contain flash bulbs
	var card = [];     // array to contain card images 
    var cardbox = [];  // array to contain card image boxes

    for ( var i = 0; i < 25; i++ )
    {   
		// clone bulb div element 
		fbox[i] = bulb.cloneNode();
		
		// set their locations
        fbox[i].style.left = (i%5) * w/5 + "px";
        fbox[i].style.top = Math.floor(i/5) * h/5 + "px";
        
		// append them to base layer container
		document.querySelector('#container').appendChild( fbox[i] );
        
		// create img element then assign to card image array
		card[i] = document.createElement( "img" );

		// set image urls to card image array 
		if( i != 24 )
			card[i].src = "images/card/" + src[i] + ".png";
		
		// select a special image later to use card back cover   
        else
           	card[i].src = "images/card/backCard.png";

        // create div elements to put into card images
		cardbox[i] = document.createElement( "div" );
        
		// set card image boxes' locations and class name
		cardbox[i].style.left = window.innerWidth/3.4 + i*5 + "px";
        cardbox[i].style.top =  window.innerHeight/3 + "px";
        cardbox[i].style.position = "absolute";
        cardbox[i].style.zIndex = "10";
        cardbox[i].className = "cardbox";
        
		// put card images into card image boxes 
		cardbox[i].appendChild( card[i] );
        
		// append card image boxes to base layer container
		var container = document.getElementById( 'container' );
        container.appendChild( cardbox[i]);
    }
	
} document.addEventListener("DOMContentLoaded", cardSuffle, false); // execution of this function
