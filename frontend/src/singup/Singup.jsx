import { useState } from "react";
import "../singup/singUp.scss";
import 'react-toastify/dist/ReactToastify.css';
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import { useNavigate } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
const SignUp = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passwordConfirm, setPasswordConfirm] = useState("");
  const [confirm, setConfirm] = useState(false);
  const [userType, setUserType] = useState("candidate"); // Mặc định là candidate

  let navigate = useNavigate();

  let handleChangeComfirmPassword = (value) => {
    setConfirm(password === value ? true : false);
    setPasswordConfirm(value);
  };

  let handleChangePassword = (value) => {
    setConfirm(passwordConfirm === value ? true : false);
    setPassword(value);
  };

  let handleClickSignUp = async () => {
    let datas = await axios.get(
      `http://localhost:8080/api/accounts/checkExist/${email}`
    );
    if (!datas.data) {
      let dataCust = await axios.get(
        "http://localhost:8080/api/customers/getID"
      );
      await axios.post("http://localhost:8080/api/customers", {
        custId: dataCust.data + 1,
        custName: "",
        email: email,
        phone: "",
        address: "",
      });
      let datasGetCust = await axios.get(
        `http://localhost:8080/api/customers/${dataCust.data + 1}`
      );

      let dataAccountId = await axios.get(
        "http://localhost:8080/api/accounts/getID"
      );
      let dataPostAcocunt = await axios.post(
        "http://localhost:8080/api/accounts",
        {
          accountId: dataAccountId.data + 1,
          email: email,
          password: password,
          userType: userType, // Thêm userType vào dữ liệu đăng ký
          customer: datasGetCust.data,
        }
      );

      if (dataPostAcocunt) {
        navigate("/");
      }
    } else {
      toast.error("🦄 Email đã tồn tại!", {
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
    <div className="container-sign-up">
      <span className="text-sign-up">ĐĂNG KÝ</span>
      <div className="form-sign-up-content">
        <label htmlFor="sign-up-email" className="sign-up-label">
          Email :{" "}
        </label>
        <input
          type="email"
          value={email}
          id="sign-up-email"
          className="sign-up-input"
          onChange={(e) => setEmail(e.target.value)}
        />
      </div>
      <div className="form-sign-up-content">
        <label htmlFor="sign-up-password" className="sign-up-label">
          Password :{" "}
        </label>
        <input
          type="password"
          value={password}
          id="sign-up-password"
          className="sign-up-input"
          onChange={(e) => handleChangePassword(e.target.value)}
        />
      </div>
      <div className="form-sign-up-content">
        <label htmlFor="sign-up-confirm-password" className="sign-up-label">
          Confirm Password :{" "}
        </label>
        <input
          type="password"
          value={passwordConfirm}
          id="sign-up-confirm-password"
          className="sign-up-input"
          onChange={(e) => handleChangeComfirmPassword(e.target.value)}
        />
        {confirm ? (
          <i
            className="fa-solid fa-circle-check icon-confirm"
            style={{ color: "green" }}
          ></i>
        ) : (
          <i
            className="fa-solid fa-circle-xmark icon-confirm"
            style={{ color: "red" }}
          ></i>
        )}
      </div>
      <div className="form-sign-up-content">
        <label htmlFor="user-type" className="sign-up-label">
          Loại tài khoản :{" "}
        </label>
        <select
          id="user-type"
          value={userType}
          onChange={(e) => setUserType(e.target.value)}
        >
          <option value="candidate">Candidate</option>
          <option value="company">Company</option>
        </select>
      </div>
      <button className="btn-sign-up" onClick={handleClickSignUp}>
        Đăng Ký
      </button>
      <ToastContainer />
    </div>
  );
};

export default SignUp;