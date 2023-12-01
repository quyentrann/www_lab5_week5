import { useState } from "react";
import "../login/login.scss";
import 'react-toastify/dist/ReactToastify.css';
import axios from "axios";
import { Link, useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import 'bootstrap/dist/css/bootstrap.min.css';

const Login = () => {
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [typeLogin, setTypeLogin] = useState("company");

  let navigate = useNavigate();

  let handleClickLogin = async () => {
    let datas = await axios.post("http://localhost:8080/login", {
      type: typeLogin,
      email: email,
      phone: phone,
    });
    console.log(datas.data);
    if (datas.data.company && !datas.data.candidate) {
      navigate("/");
    } else if (!datas.data.company && datas.data.candidate) {
      navigate("/Home", { state: { user: datas.data.data } });
    } else {
      toast.error('🦄 Email, Phone Hoặc Loại Đăng Nhập Không Đúng!', {
        position: "top-right",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
      });
    }
  };

  return (
    <div className="container-login">
      <span className="text-login">ĐĂNG NHẬP</span>

      <div className="form-login-content">
        <label htmlFor="login-email" className="login-label">
          Email :{" "}
        </label>
        <input
          style={{ marginRight: "20px" }}
          type="email"
          value={email}
          id="login-email"
          className="login-input"
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>
      <div className="form-login-content">
        <label htmlFor="login-password" className="login-label">
          Phone :{" "}
        </label>
        <input
          type="tel"
          value={phone}
          id="login-password"
          className="login-input"
          onChange={(e) => setPhone(e.target.value)}
        />
        <select
          style={{
            height: "40px",
            width: "120px",
            borderRadius: "5px",
            marginTop: "10px",
            marginLeft: "20px",
          }}
          value={typeLogin}
          onChange={(e) => setTypeLogin(e.target.value)}
        >
          <option value={"company"}>COMPANY</option>
          <option value={"candidate"}>CANDIDATE</option>
        </select>
      </div>

      <div className="ac">
        <button className="btn-login" onClick={handleClickLogin}>
          Đăng Nhập
        </button>
        <Link style={{ marginTop: '10px', marginLeft: "40px", fontSize: "16px" }} to={"/sign-up"}>Đăng ký</Link>
      </div>
      <ToastContainer />
    </div>
  );
};

export default Login;