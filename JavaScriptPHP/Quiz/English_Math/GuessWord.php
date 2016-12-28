<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/styleeh3.css">
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
                /*
            	$image = "/image/eh3/$i.jpg";
             	*/
                $file = "/adfile/eh3/$i.txt";
             	$data = file($file);
                $count = count($data);

    			$entireText="";

				echo "<li><section>";
            	echo "<p>".$data[1]."</p>";

				for ($p = 16; $p < $count; $p++)
                  	$entireText .= $data[$p];

				$splitedText = explode(' ', $entireText);
                /*
                $countedWord = "Total Words: ".count($splitedText)."<br>";
                */
				for ($p = 0; $p < count($splitedText); $p++)
				{
                    $mark="";

                    for ($k = 0; $k < strlen($splitedText[$p]); $k++)
                        $mark .="*";

                    print_r("<span id='word".$i."_".$p."'>".$mark."</span>"." ");

                    echo "<script>document.getElementById('word".$i."_".$p."').style.backgroundColor = 'orange';</script>";

                    echo "<script>document.getElementById('word".$i."_".$p."').onclick=
                         function()
                         {
                            document.getElementById('word".$i."_".$p."').style.backgroundColor = 'yellow';

                            if($p > 0)
                            {
                            document.getElementById('word".$i."_".($p-1)."').style.backgroundColor = 'transparent';
                            }

                            document.getElementById('word".$i."_".$p."').innerHTML = '".$splitedText[$p]."'; ";
                            /*
                            echo " document.getElementById('wc".$i."').innerHTML = '".$splitedText[$p]."'; ";

                            $cnt = 1;

                            for($m = $p+1; $m < count($splitedText); $m++)
                            {
                                if(strtolower($splitedText[$p]) == strtolower($splitedText[$m]))
                                {
                                    $cnt++;
                                    /*
                                    echo "
                                    document.getElementById('word".$i."_".$m."').style.backgroundColor = 'yellow';
                                    document.getElementById('word".$i."_".$m."').innerHTML = '".$splitedText[$m]."';
                                        ";
                                }
                            }

                            $countedWord .= chop($splitedText[$p],"<br>")." ".$cnt.", ";

                            echo "
                                document.getElementById('wc".$i."').innerHTML = '".$countedWord."';
                                ";
                            */

                            echo "
                        }</script>";
                }
                /*
			    print_r("<p id='wc".$i."'></p>");
                */
                echo "</section></li>";

                $i++;

            } while (file_exists("/adfile/eh3/$i.txt"));
        ?>
        </ol>
    <footer></footer>
</body>
</html>
