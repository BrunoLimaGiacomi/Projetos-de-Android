<?php
 echo $_FILES['image']['name'] . '<br/>';
  ini_set('upload_max_filesize', '10M');
  $target_path = "imagem/";
 $target_path = $target_path . basename($_FILES['image']['name']);
 
  try {
   if (!move_uploaded_file($_FILES['image']['tmp_name'], $target_path)) {
  throw new Exception('final');
  }
  echo "Image uploaded";
  } catch (Exception $e) {
die('Image did not upload: ' . $e->getMessage());
  }
  ?>