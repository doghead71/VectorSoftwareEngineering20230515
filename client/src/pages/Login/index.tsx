import React, { FunctionComponent, useState } from 'react'
import styled from 'styled-components'
import InputField from '../../components/InputField';
import Button, { Type } from '../../components/Button';
import background from '../../assets/images/background-img.jpg'
const Login: FunctionComponent = () => {

    const [registerValues, setRegisterValues] = useState<any>([]); // To Do
    const [loginValues, setLoginValues] = useState<any>([]);

    const onLoginChange = (e: React.ChangeEvent<HTMLInputElement>, name : string) => {
        const {value} = e.target;
        setLoginValues({
            ...loginValues,
            [name]: value
        });
    };

    const onRegisterChange = (e: React.ChangeEvent<HTMLInputElement>, name : string) => {
        const {value} = e.target;
        setRegisterValues({
            ...registerValues,
            [name]: value
        });
    };

    return (
        <LoginWrapper>
            <img className="field" src={background} alt="background"/>
              <div className="container">
              <div className="login-side">
                  <h1 className="login">Login</h1>
                  <div>
                  <div className="form-group">
                      <InputField 
                      type={"text"}
                      placeholder='Username or Email eg: fotball123@gmail.com'
                      value={loginValues?.username}
                      onChange={e => onLoginChange(e, 'email')}
                      />
                  </div>
                  <div className="form-group">
                      <InputField 
                          type={"password"}
                          placeholder='Password'
                          value={loginValues?.password}
                          onChange={e => onLoginChange(e, 'password')}
                      />
                  </div>
                  <div className="form-group remember-forget">
                  <input type="checkbox" id="remember-me" name="remember-me"/>
                  <label htmlFor="remember-me">Remember me</label>
                  <a href="forgot-password.php">Forgot password?</a>
                  </div>
                  <div className="form-group">
                      <Button
                          type={Type.SUBMIT}
                          onClick={() => console.log( 'userInfo: ', loginValues)}
                          buttonTitle='Login'
                          buttonSyles={buttonStyles}

                      />
                  </div>
                  </div>
              </div>
              <div className="vl">
              </div>
              <div className="register-side">
                  <h1 className="register">Register</h1>
                  <div>
                  <div className="form-group">
                      <InputField 
                          type={"text"}
                          placeholder={'First Name'}
                          value={registerValues?.firstName}
                          onChange={e => onRegisterChange(e, 'firstName')}
                      />
                  </div>
                  <div className="form-group">
                      <InputField 
                          type={"text"}
                          placeholder={'Last Name'}
                          value={registerValues?.lastName}
                          onChange={e => onRegisterChange(e, 'lastName')}
                      />
                  </div>
                  <div className="form-group">
                      <InputField 
                          type={"text"}
                          placeholder={'Username'}
                          value={registerValues?.userName}
                          onChange={e => onRegisterChange(e, 'userName')}
                      />
                  </div>
                  <div className="form-group">
                      <InputField 
                          type={"email"}
                          placeholder='Email'
                          value={registerValues?.email}
                          onChange={e => onRegisterChange(e, 'email')}
                      />  
                  </div>
                  <div className="form-group">
                      <InputField 
                          type={"password"}
                          placeholder={'Password'}
                          value={registerValues?.password}
                          onChange={e => onRegisterChange(e, 'password')}
                      />
                  </div>
                  <div className="form-group">
                      <InputField 
                          type={"password"}
                          placeholder={'Confirm Password'}
                          value={registerValues?.confirm_password}
                          onChange={e => onRegisterChange(e, 'confirm_password')}
                      />
                  </div>
                  <div className="form-group">
                      <Button
                          type={Type.SUBMIT}
                          onClick={() => console.log( 'userInfo: ', registerValues)}
                          buttonTitle='Register'
                          buttonSyles={buttonStyles}
                      />
                  </div>
                  </div>
              </div>
              </div>
        </LoginWrapper>
    )
};

export default Login;

const buttonStyles ={
    backgroundColor : '#63666A',
    width: '100%',
    padding: '10px',
    color: '#ffffff',
    border: 'none',
    borderRadius: '3px',
    cursor: 'pointer',
}
const LoginWrapper = styled.div`
body {
    font-family: Arial, sans-serif;
    background-color: whitesmoke;
    background-image: url('../../assets/images/background-img.jpg');
  }
  

  .field {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
    z-index: -1;
    filter: blur(4px);
  }


  .container {
    width: 750px;
    height: 440px;
    margin:  auto;
    margin-top: 200px;
    padding: 20px;
    background-color: #ffffff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    display: flex;
  }

  .vl{
    border-left: 6px solid #63666A;
  height: 436px;
  left: 50%;
  margin-left: 1px;
  top: 7px;
  }

  .login-side,
  .register-side {
    flex: 1;
    padding: 20px;
  }
  
  .login {
    background-color: #63666A;
  }

  .register {
    background-color: #63666A;
  }
  
  h1 {
    text-align: center;
    color: #f4f0f0;
    margin-bottom: 20px;
    border-radius: 6px;
    padding-bottom: 6px;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  label {
    display: block;
    margin-bottom: 5px;
    color: #666666;
  }
  
  input[type="text"],
  input[type="password"],
  input[type="email"] {
    width: 95%;
    padding: 8px;
    border: 1px solid #dddddd;
    border-radius: 3px;
  }
  
  input[type="checkbox"] {
    margin-right: 5px;
  }
  
  a {
    color: #666666;
  }
  
  input[type="submit"] {
    width: 100%;
    padding: 10px;
    background-color: #63666A;
    color: #ffffff;
    border: none;
    border-radius: 3px;
    cursor: pointer;
  }
  
  input[type="submit"]:hover {
    background-color: #45a049;
  }
  
  .form-group.remember-forget {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .form-group.remember-forget label {
    margin-right: 70px;
    margin-top: 5px;
  }

  @media (max-width: 600px) {
    .container {
      padding: 10px;
    }
  }
`;
