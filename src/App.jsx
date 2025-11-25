// src/App.jsx
import ProfileList from "./components/ProfileList";
import ProfileCard from "./components/ProfileCard";
import StepCounter from "./components/StepCounter";
import ProductInfo from "./components/ProductInfo";
import "./App.css"; // Make sure to import CSS

// Component to wrap each letter in a span for animation
const JumpingText = ({ text }) => {
  return (
    <>
      {text.split('').map((char, index) => (
        <span key={index} style={{ animationDelay: `${index * 0.1}s` }}>
          {char === ' ' ? '\u00A0' : char}
        </span>
      ))}
    </>
  );
};

function App() {
  return (
    <div className="app-container">
      <h1>
        <JumpingText text="React Lab Activity" />
      </h1>

      <ProfileList />

      {/* Single StepCounter with new label */}
      <StepCounter />

      <ProductInfo
        name="Smartphone"
        price={799}
        details="Latest smartphone with a 6.7-inch OLED display, 5G connectivity, and 128GB storage."
      />

      <ProductInfo
        name="Wireless Headphones"
        price={249}
        details="Noise-cancelling wireless headphones with up to 30 hours of battery life and Bluetooth 5.0."
      />
    </div>
  );
}

export default App;
