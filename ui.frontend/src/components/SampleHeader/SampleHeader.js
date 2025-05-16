import React from 'react';
import { MapTo } from '@adobe/aem-react-editable-components';
import { Link } from 'react-router-dom';
import './SampleHeader.css';
import headerLogo from '../../media/header-logo.svg';
import messageImage from '../../media/header-msg-icon.svg';
import homeImage from '../../media/hdfclife-home.svg';
import searchImage from '../../media/header-search-icon.svg';

const SampleHeader = ({ navigationItems = [] }) => {
  if (!navigationItems.length) return null;

  return (
    
      <div className="header-component">
        <header className='header-container'>
          <img src={headerLogo} alt="heade-Logo" />
          <p>From the Header</p>
          <img src={messageImage} alt="header-msg-icon" />
        </header>        
        <nav className='header-nav-conatiner'>
          <div className='header-nav-first-section'>
            <div className='header-nav-option-section'>
              <ul>
                <li>
                  <img src={homeImage} alt="hdfclife-home" />
                </li>
                {navigationItems.map((item, index) => (
                  <li key={index} className="nav-item">
                    <Link to={item.url}>{item.title}</Link>
                  </li>
                ))}
              </ul>
            </div>
          </div>
          <div className='header-nav-search-section'>
            <ul>
              <li>
                <img src={searchImage} alt="header-search-icon" />
              </li>
            </ul>
          </div>
        </nav >      
      </div>
    
  );
};

// Map to AEM component
MapTo('aem-spa-react/components/header')(SampleHeader, {
  emptyLabel: 'SampleHeader',
  isEmpty: (props) => !props || !props.navigationItems || props.navigationItems.length === 0
});

export default SampleHeader;
