import axios from "axios";
import { useEffect, useState } from "react";
import { Button, Card, Col, Container, DropdownButton, Dropdown, Pagination, Row } from "react-bootstrap";
import { useLocation, useNavigate } from "react-router-dom";
import "./home.scss";
import 'bootstrap/dist/css/bootstrap.min.css';

const Home = () => {
  const navigate = useNavigate();
  const location = useLocation();
  const [pageSize, setPageSize] = useState(6);
  const [companies, setCompanies] = useState([]);
  const [pageChosen, setPageChosen] = useState(0);
  const [totalPages, setTotalPages] = useState([]);
  const [user, setUser] = useState({});

  useEffect(() => {
    setUser(location.state.user);
  }, [JSON.stringify(location.state.user)]);

  useEffect(() => {
    const apiGetDataInfo = async () => {
      const data = await axios.get(
        `http://localhost:8080/company/get-page/${pageChosen}?pageSize=${pageSize}`
      );
      setTotalPages(Array.from({ length: data.data.totalPages }, (_, index) => index + 1));
      setCompanies(data.data.companies);
    };
    apiGetDataInfo();
  }, [pageChosen, pageSize]);

  const handlePressWork = (id) => {
    navigate("/detail-work", { state: { companyID: id, user: user } });
  };

  return (
    <Container className="home-container mt-5">
      <Row className="mb-4">
        <Col>
          <div className="d-flex align-items-center" style={{ marginLeft: "1000px" }}>
            <i className="fa-solid fa-user icon me-1"></i>
            <span className="user-name">{user.fullName !== undefined && user.fullName}</span>
          </div>
        </Col>
      </Row>
      <Row className="mb-3">
        <Col>
          <h2 className="header">THÔNG BÁO TUYỂN DỤNG</h2>
        </Col>
      </Row>
      <Row xs={1} md={2} lg={3} className="g-4">
        {companies.map((data, index) => (
          <Col key={index}>
            <Card className="h-100">
              <Card.Body>
                <Card.Title style={{ fontSize: "20px", fontWeight: "bold" }}>{data.name}:</Card.Title>

                <Card.Text>{data.about}</Card.Text>
                <Button variant="primary" onClick={() => handlePressWork(data.id)}>
                  Xem chi tiết
                </Button>

              </Card.Body>
            </Card>
          </Col>
        ))}
      </Row>
      <Row className="mb-4">
        <Col className="d-inline">
          <Pagination>
            {totalPages.map((data, index) => (
              <Pagination.Item
                key={index}
                active={pageChosen === index}
                onClick={() => setPageChosen(index)}
              >
                {data}
              </Pagination.Item>
            ))}
          </Pagination>
        </Col>
       
      </Row>
    </Container>
  );
};

export default Home;