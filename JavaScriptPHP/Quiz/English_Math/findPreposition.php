<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/styleeh2.css">
    <title>Social Activity</title>
</head>
<body>
    <header>
    </header>
        <ol>
        <?php

            $i = 101;

			do
			{
            	$image = "/image/eh2/$i.jpg";
             	$file = "/adfile/eh2/$i.txt";
             	$data = file($file);
             	$count = count($data);

				$preposition="";
				$entireText="";

				echo "<li><section>";
            	echo "<p>".$data[1]."</p>";

				for ($p = 3; $p < 16; $p++)
			    	$preposition .= $data[$p];

            	$splitpreposition = explode(' ', $preposition);

				for ($p = 16; $p < $count; $p++)
			    	$entireText .= $data[$p];

				$splitedText = explode(' ', $entireText);

				for ($p = 0; $p < count($splitedText); $p++)
				{
					print_r("<span id='word".$i."_".$p."'>".$splitedText[$p]."</span>"." ");

					$mark="";
					for ($k = 0; $k < strlen($splitedText[$p]); $k++)
						$mark .="*";

			        if(in_array(strtolower($splitedText[$p]), $splitpreposition))
					{
						echo "<script>document.getElementById('word".$i."_".$p."').style.backgroundColor = 'orange';</script>";
						echo "<script>document.getElementById('word".$i."_".$p."').innerHTML = '".$mark."';</script>";
						echo "<script>document.getElementById('word".$i."_".$p."').onclick =
			      				  function(){
			      						document.getElementById('word".$i."_".$p."').style.backgroundColor = 'yellow';
			      						document.getElementById('word".$i."_".$p."').innerHTML = '".$splitedText[$p]."';
				                  };</script>";
					}
				}

			echo "</section></li>";

            $i++;

          } while (file_exists("/adfile/eh2/$i.txt"));
        ?>
        </ol>
    <footer></footer>
</body>
</html>
