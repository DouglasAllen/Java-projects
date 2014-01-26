require 'java'
java_import 'MidiPlayer'
java_import 'MainWindow'
java_import 'Program'

MidiPlayer.public_methods(false) {|i| puts i }
MainWindow.public_methods(false) {|i| puts i }
Program.public_methods(false) {|i| puts i }

main = Program.new