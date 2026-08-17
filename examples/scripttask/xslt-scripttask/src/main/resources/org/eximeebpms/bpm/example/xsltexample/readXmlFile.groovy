import org.eximeebpms.commons.utils.IoUtil

xmlData = IoUtil.fileAsString('org/eximeebpms/bpm/example/xsltexample/example.xml')
execution.setVariable('customers', xmlData)

println 'Input XML:'
println xmlData
