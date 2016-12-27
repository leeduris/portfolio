/* myscript */
var xmlData;    // hold the xml file from ajax call
var rowID;		// hold the user selection

// get our data from xml
$(document).on("pagecreate", "#home", function(){
	console.log("in doc on");
	
	// ajax call to load the xml file
	$.ajax({
		type : "GET", url : "books.xml", dataType : "xml", 
		success : function(xml) {
			xmlData = xml;
			console.log(xmlData);
			buildmenu(xml, "Assignment 2")
		},
		error: function (e) {
			alert(e.status + "-" + e.statusText);
		}
	});	
});

function buildmenu(xml, title){
	// var to hold id (dynamic for each <li>)
	var n = 0;
	$("h1").html(title);
	$("h1").append("<br>" + $(xml).find("site").text());
	$("h4").html("Student Name: " + $(xml).find("student").text() + 
				 "<br>Student ID: " + $(xml).find("student").attr("number") +
				 "<br>Student Course: " + $(xml).find("student").attr("program")
	);
	
	$("#navhome").html("<ul id='listhome'><li>" +
		"<a href='#home' class='ui-btn ui-icon-home ui-btn-icon-top'>HOME</a>" + 
		"</li></ul>");
	
	// loop through <book> nodes
	$(xml).find("book").each(function(){
		// create <li> for each book name
		$("ul#bookMenu").append(
			 "<li li-id='" + n + "'>" +
				"<a href='#individual'>" +
				 $(this).find("name").text() +
				"</a>" + 
			"</li>"
		);
		
		// create <li> for each book name 
		$("#listhome").append(
			 "<li li-id='" + n + "'>" +
				"<a href='#individual' class='ui-btn ui-icon-book ui-btn-icon-top'>" +
				 $(this).find("abbr").text() +
				"</a>" + 
			"</li>"
		);
			
	    n++;
	});	// end of book loop
	
	$("ul#bookMenu").listview("refresh");   // bring in query Mobile format
	$("#navhome").navbar("destroy");
	$("#navhome").navbar(); 	
}  // end of buildmenu

// save user selection
$(document).on("click", "#bookMenu >li", function(){
	rowID = $(this).closest("li").attr("li-id");
	console.log(rowID);
	parseXML(xmlData, rowID);
});


$(document).on("click", "#listhome >li", function(){
	rowID = $(this).closest("li").attr("li-id");
	console.log(rowID);
	parseXML(xmlData, rowID);
});


// build individual page
function parseXML(xml, choice) {
	$("#bookinfo").html(
		"<br><br>Title:" + $(xml).find("name:nth(" + choice + ")").text() + 
		"<hr>Author:" + $(xml).find("author:nth(" + choice + ")").text() +
		"<hr>publisher:" + $(xml).find("publisher:nth(" + choice + ")").text() +
		"<hr>Genre:" + $(xml).find("desc:nth(" + choice + ")").attr("type") +
		"<hr>price:" + $(xml).find("price:nth(" + choice + ")").text() + "<hr>"
		); 
		 
	$("#bookimg").html(	 
		"<br><br><img src='" + $(xml).find("name:nth(" + choice + ")").attr("image") + "'>"
	);
	
	$("#bookdesc").html(	 
		"Description:" + $(xml).find("desc:nth(" + choice + ")").text() + "<br>"
	);
	
	$("#review").html($(xml).find("review:nth(" + choice + ")").text());
	
	$("#indigo").html(
		"<a href='" + $(xml).find("indigo:nth(" + choice + ")").text() + 
		"'><button class='ui-btn ui-icon-indigo ui-btn-icon-notext'>GO TO</button></a>");
		
	$("#display").collapsibleset("refresh");	
}
