

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        
        <h2>Edit Note</h2>
        
        <form method="POST" action="note">
            <label>Title:</label>
            <input type="text" name="editTitle" value="${note.title}">
            <br>
            <label>Content:</label>
            <textarea type="textbox" name="editContent" rows="10" cols="25" value="">${note.content}</textarea>
            <br><br>
            <input type="submit" value="Save">
        </form>
     
    </body>
</html>
