<?php

	$callback = isset($_GET["callback"])?$_GET["callback"]:"callback";

	$foo = isset($_GET["foo"])?$_GET["foo"]:"'";

	$format = isset($_GET["format"])?$_GET["format"]:"";
	
	$array = array("foo"=>$foo,"format"=>$format);

	echo $callback . "(". json_encode($array). ")";

?>