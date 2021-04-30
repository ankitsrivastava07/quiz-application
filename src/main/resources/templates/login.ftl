<!------ Include the above in your HEAD tag ---------->
<div class="modal show" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Login</h5>
        <button type="button" class="close" onclick="loginPopClose();" id="pop-close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="form-group">
          <form id="login-form" method="post" name="login-form">
            <label for="recipient-name" class="col-form-label">Email ID / Username </label>
            <input type="text" class="form-control" name="email" id="email" Placeholder="Enter your email/username" autocomplete=off/>
          </div>
          <div class="form-footer"">
            <label for="recipient-name" class="col-form-label">Password</label>
            <input type="password" class="form-control" name="password" id="password" Placeholder="Enter your password" id="password"/>
          </div>
        
      </div>
      <div class="modal-footer">
      <input type="submit" id="submit" class="btn btn-primary" value="Login">
      </div>
       <center><span class="msg">Don't have an account?</span>
        <a href="/register" class="register-form" for="message-text">Register</button></label></center>
    </div>
</form>     
  </div>
</div>
 
