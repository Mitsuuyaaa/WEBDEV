// src/components/ProfileList.jsx
import ProfileCard from "./ProfileCard";

function ProfileList() {
  return (
    <div>
      <ProfileCard name="Mitsu" age={19} role="Duelist" />
      <ProfileCard name="Haru" age={30} role="Sentinel" />
      <ProfileCard name="Draken" age={35} role="Initiator" />
    </div>
  );
}

export default ProfileList;