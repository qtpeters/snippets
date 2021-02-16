
## Commit the image
docker container commit <container id OR container name> <image-name>:<tag>

OR

## Build the image
docker build -t <docker-group>/<image-name> .

## list the images to see if the one we just made is there
docker images

## Tag the image with the remote repository ( Nexus )
docker image tag <image-name>:<tag> <registry-host>:<port>/<docker-group>/<image-name>:<tag>

## Push the image to the repository
docker image push <registry-host>:<port>/<docker-group>/<image-name>:<tag>
