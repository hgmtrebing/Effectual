const React = require('react');
const ReactDOM = require('react-dom');

class AdminUsers extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    render() {
        return (
            <p>
                test users page
            </p>
        );
    }
}