import React, { Component } from 'react';

class ConvertNumberComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            from: '',
            to: '',
            number: '',
            result: ''
        }

        this.changeFromHandler = this.changeFromHandler.bind(this);
        this.changeToHandler = this.changeToHandler.bind(this);
        this.changeNumberHandler = this.changeNumberHandler.bind(this);
        this.changeResultHandler = this.changeResultHandler.bind(this);
        this.convertNumber = this.convertNumber.bind(this);
    }

    convertNumber(e) {
        e.preventDefault();
        let request = {
            from: this.state.from,
            to: this.state.to,
            number: this.state.number
        };
        console.log('request => ' + JSON.stringify(request));

        // Call your service method here to handle the conversion
    }

    changeFromHandler(event) {
        this.setState({ from: event.target.value });
    }

    changeToHandler(event) {
        this.setState({ to: event.target.value });
    }

    changeNumberHandler(event) {
        this.setState({ number: event.target.value });
    }

    changeResultHandler(event) {
        this.setState({ result: event.target.value });
    }

    cancel() {
        this.props.history.push('/employees');
    }

    getTitle() {
        return <h3 className="text-center">Convert Number</h3>
    }

    render() {
        return (
            <div>
                <br />
                <div className="container">
                    <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
                            <div className="card-body">
                                <form>
                                    <div className="form-group">
                                        <label>From:</label>
                                        <select className="form-control" value={this.state.from} onChange={this.changeFromHandler}>
                                            <option value="">--Select From--</option>
                                            <option value="BINARY">Binary</option>
                                            <option value="DECIMAL">Decimal</option>
                                        </select>
                                    </div>
                                    <div className="form-group">
                                        <label>To:</label>
                                        <select className="form-control" value={this.state.to} onChange={this.changeToHandler}>
                                            <option value="">--Select To--</option>
                                            <option value="ROMAN">Roman</option>
                                        </select>
                                    </div>
                                    <div className="form-group">
                                        <label>Number:</label>
                                        <input placeholder="Number" name="number" className="form-control"
                                               value={this.state.number} onChange={this.changeNumberHandler} />
                                    </div>
                                    <div className="form-group">
                                        <label>Result:</label>
                                        <input
                                            name="result"
                                            className="form-control"
                                            value={this.state.result}
                                            onChange={this.changeResultHandler}
                                            readOnly
                                        />
                                    </div>

                                    <button className="btn btn-success" onClick={this.convertNumber}>Convert</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default ConvertNumberComponent;
