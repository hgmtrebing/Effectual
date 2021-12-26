const React = require('react');
const ReactDOM = require('react-dom');

/* Test */
class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            tasks: [],
            projects: []
        }
    }

    componentDidMount() {
    }

    render() {
        return (
            <p>test</p>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('react')
)