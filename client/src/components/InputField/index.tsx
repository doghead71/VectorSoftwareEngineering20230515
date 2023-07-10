import React, { FunctionComponent } from 'react'
import styled, {css} from 'styled-components'

type InputProps = {
type: string,
placeholder?: string,
onChange?: (event: any) => void,
value?: string,
title?: string,
required?: boolean
}

const InputField : FunctionComponent<InputProps> = (props)=> {
    const {type = 'text', placeholder, onChange, value, title} = props;

    return (
        <InputFieldWrapper>
            <Input
                type={type}
                placeholder={placeholder}
                onChange={onChange}
                value={value}
            />
        </InputFieldWrapper>
    )
};

export default InputField;

const InputFieldWrapper = styled.div`
`

const Input = styled.input`
`;
