require 'rake'

require 'fileutils'

target_dir = 'bluej'

files_to_keep = ['README.TXT', 'package.bluej']
IGNORED_FILES = ['P4Utils.java']

def keep_files?(path)
  file = File.basename path
  files_to_keep.include? file
end

def ignore_file?(file)
  IGNORED_FILES.include? File.basename(file)
end


def copy_file_keep_structure(file, target_dir, trim)
  dir, filename = File.dirname(file), File.basename(file)
  dest = File.join(target_dir, dir)
  dest.gsub! trim, ''
  FileUtils.mkdir_p(dest)
  FileUtils.copy_file(file, File.join(dest,filename))
end

task :bluej, [] => [:clean, :copy] do |t, args|
  paths = args.extras
  paths.each do |path|
    raise ArgumentError.new('path_to_source is required') unless path && path.strip != ''
    Dir.glob("#{path}/**/*").each do |file|
      copy_file_keep_structure file, target_dir, path unless ignore_file?(file)
    end
  end

end


task :clean do
  # FileUtils.rm Dir["#{target_dir}/*"]
  `rm -r #{target_dir}/*` if Dir["#{target_dir}/*"].size > 0
end

task :copy do
  Dir['bluej-files/**/*'].each do |file|
    copy_file_keep_structure file, target_dir, 'bluej-files'
  end
end
