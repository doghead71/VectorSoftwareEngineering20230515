import React, { CSSProperties, FunctionComponent } from "react";
import styled, {css} from 'styled-components'

export enum Type {
    BUTTON = 'button',
    RESET = 'reset',
    SUBMIT = 'submit'
}

type ButtonProps = {
    buttonTitle: string,
    className?: string,
    onClick?: (data?: any) => (any | void),
    isDisabled?: boolean,
    buttonSyles?: CSSProperties,
    type: Type,

}
const Button: FunctionComponent<ButtonProps> = (props) => {
    const {buttonSyles = {}, onClick, isDisabled = false, buttonTitle = '', type, className } = props

    return (
        <ButtonWrapper
            className={className}
            style={{...buttonSyles}}
            type={type}
            disabled={isDisabled}
            onClick={onClick}
        >
            {buttonTitle}   
        </ButtonWrapper>
    )
} 

export default Button;

type StyleProps = {
    outline?: boolean,
    primary?: boolean,
    disabled?: boolean,
    selected?: boolean,
    iconOnly?: boolean,
    clear?: boolean
}
const ButtonWrapper= styled.button<StyleProps>`
`;


