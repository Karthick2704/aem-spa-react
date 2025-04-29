import React, {Component} from 'react';
import {MapTo} from '@adobe/aem-react-editable-components';
import './Custom.css';
import headerLogo from '../../media/header-logo.svg';
import messageImage from '../../media/header-msg-icon.svg';
import homeImage from '../../media/hdfclife-home.svg';
import searchImage from '../../media/header-search-icon.svg';

export const CustomEditConfig = {

    emptyLabel: 'Custom',

    isEmpty: function(props) {
        return !props || !props.message || props.message.trim().length < 1;

    }
};

export default class Custom extends Component {

    render() {
        if(CustomEditConfig.isEmpty(this.props)) {
            return null;
        }

        return (
            <>
            <div className='header-component'>
                <header className='header-container'>
                    <img src={headerLogo} alt="heade-Logo" />
                    <p>&copy; {new Date().getDate()} {new Date().getMonth() + 1} {new Date().getFullYear()} {this.props.message}</p>
                    <img src={messageImage} alt="header-msg-icon" />
                </header>
                <nav className='header-nav-conatiner'>
                    <div className='header-nav-first-section'>
                        <div className='header-nav-option-section'>
                            <ul>
                                <li>
                                    <img src={homeImage} alt="hdfclife-home" />
                                </li>
                                <li>Retirement</li>
                                <li>Investments</li>
                                <li>Savings</li>
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
        </>
        );
    }
}

MapTo('aem-spa-react/components/custom-component')(Custom, CustomEditConfig);
