import React, { useEffect, useState } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.min.css';
import "./detailWork.scss";

const DetailWork = () => {
  const [jobs, setJobs] = useState([]);
  const [jobsFit, setJobsFit] = useState([]);
  const [user, setUser] = useState({ id: 1 });
  let location = useLocation();

  useEffect(() => {
    setUser(location.state.user);
  }, [JSON.stringify(location.state.user)]);

  useEffect(() => {
    const apiGetDataInfo = async () => {
      const data = await axios.get(
        `http://localhost:8080/company/get-info/${location.state.companyID}`
      );
      setJobs(data.data);
    };
    apiGetDataInfo();
  }, [location.state.companyID]);

  useEffect(() => {
    const apiGetSkillCandidate = async () => {
      const datas = await axios.post(
        `http://localhost:8080/company/get-skill-candidate`,
        {
          candidateID: user.id,
          companyID: location.state.companyID,
        }
      );
      setJobsFit(datas.data);
    };
    apiGetSkillCandidate();
  }, [user.id, location.state.companyID]);

  return (
    <div className="container-detail-work">
      <span className="header">{jobs.length > 0 && jobs[0].job.company.name}</span>
      <div className="content-works">
        {jobs.map((data, index) => (
          <div
            key={index}
            className={`content-work ${jobsFit.find(
              (j) =>
                j.job.id === data.job.id &&
                j.skill.id === data.skill.id &&
                j.job.level === data.job.level
            ) !== undefined && "highlighted"}`}
          >
            <span className="description-job">{data.job.description}</span>
            <div className="content-company">
              <span>Skill_Name : {data.skill.skillName}</span>
              <span>Skill_Type : {data.skill.skillType}</span>
              <span>Skill_Description : {data.skill.skillDescription}</span>
              <span>Level : {data.level}</span>
              <span>More_Information : {data.moreInfo}</span>
              {jobsFit.find(
                (j) =>
                  j.job.id === data.job.id &&
                  j.skill.id === data.skill.id &&
                  j.job.level === data.job.level
              ) !== undefined && (
                <span style={{marginLeft:"600px", fontWeight:"bold"}} className="fit-indicator">
                  &#10004; Phù hợp
                </span>
              )}
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default DetailWork;