from flask import Flask, request, jsonify
from flask_restful import Resource, Api
from sqlalchemy import create_engine


db_connect = create_engine('mysql://root:f4t455@localhost:3306')
app = Flask(__name__)
api = Api(app)


@app.route('/')
def hello_hack():
    return 'API Restful para la hackathon de contact tracing'


class Comunidades(Resource):
    def get(self):
        conn = db_connect.connect()
        conn.execute("USE ctracing")
        query = conn.execute("SELECT * FROM Comunidad;")
        return {'Comunidades': [i[0:9] for i in query.cursor.fetchall()]}


class Usuarios(Resource):

    def get(self):
        conn = db_connect.connect()
        conn.execute("USE ctracing")
        query = conn.execute("SELECT * FROM Usuario;")
        result = {'Usuarios': [i[0:9] for i in query.cursor.fetchall()]}
        return jsonify(result)

    def post(self):
        conn = db_connect.connect()
        conn.execute("USE ctracing")
        usu_dni = request.json['usuDni']
        usu_nom = request.json['usuNom']
        gen_id = request.json['genId']
        usu_fec_nac = request.json['usuFecNac']
        com_ide = request.json['comIde']
        tip_usu_ide = request.json['tipUsuIde']
        usu_cul = request.json['usuCul']
        query = conn.execute(
            "INSERT INTO Usuario(usuDni, usuNom, genId, usuFecNac, comIde, tipUsuIde, usuCul)"
            "VALUES({0},'{1}', {2}, '{3}', {4}, {5}, '{6}')".format(
                usu_dni, usu_nom, gen_id, usu_fec_nac, com_ide, tip_usu_ide, usu_cul
            )
        )
        return {'status': 'Nuevo Usuario añadido'}


api.add_resource(Comunidades, '/comunidades')
api.add_resource(Usuarios, '/usuarios')


if __name__ == '__main__':
    app.run(debug=True)
