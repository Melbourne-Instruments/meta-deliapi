SYSTEMD_DEFAULT_TARGET = "custom-elk.target"

IMAGE_LINGUAS += "en-us"

IMAGE_INSTALL += "\
    packagegroup-elk-applications \
    packagegroup-elk-libs-basic \
    packagegroup-monique-system-basic \
    packagegroup-elk-raspberrypi-system-pkgs \
    packagegroup-elkpi-apps-basic \
    packagegroup-elkpi-system-basic-pkgs \
    packagegroup-elk-python-basic \
"

IMAGE_INSTALL_remove = " dropbear"

TOOLCHAIN_HOST_TASK += "\
    nativesdk-grpc \
    nativesdk-grpc-dev \
"

# Set permissions for delia user for home/delia
set_special_permissions () {
    chown -R delia ${IMAGE_ROOTFS}/home/delia
    chgrp -R delia ${IMAGE_ROOTFS}/home/delia
}

ROOTFS_POSTPROCESS_COMMAND += "set_special_permissions; "

# Function which prerares the dual rootfs and udata partitions for the final image
do_wic_image_prepare() {
    sed -i 's/console=serial0,115200/console=${SERIAL_CONSOLES}/' ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/cmdline.txt
    wic cp ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/cmdline.txt ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:1
    #change perm on first boot service condition file in udata
    echo "change_perms" > ${DEPLOY_DIR_IMAGE}/change_perms
    wic cp ${DEPLOY_DIR_IMAGE}/change_perms ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/change_perms

    #setup delia
    wic cp ${DEPLOY_DIR_IMAGE}/config.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/config.json
    wic cp ${DEPLOY_DIR_IMAGE}/001_FACTORY_TEST.json ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/001_FACTORY_TEST.json
    wic cp ${DEPLOY_DIR_IMAGE}/wavetables.tar.xz ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    rm -f ${DEPLOY_DIR_IMAGE}/wavetables.tar.xz

    wic ls ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic:4
    bzip2 -c ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic > ${DEPLOY_DIR_IMAGE}/${DISTRO}-firmware-${SWU_VERSION}.wic.bz2
}

addtask wic_image_prepare after do_image_complete before do_rm_work
