SUMMARY = "Image for Elk Pi which contains basic packages"
HOMEPAGE = "https://github.com/elk-audio/meta-elkpi"

require recipes-core/images/core-image-minimal.bb
require deliapi-common.inc

inherit populate_sdk_qt5

IMAGE_INSTALL += "\
    packagegroup-core-tools-debug \
    moniquepi-user-files \
    packagegroup-monique-applications \
    packagegroup-elk-qt-pkgs \
"

EXTRA_IMAGE_FEATURES += " ssh-server-openssh package-management"

IMAGE_ROOTFS_SIZE = "1310720"
IMAGE_OVERHEAD_FACTOR = "1.0"
IMAGE_ROOTFS_EXTRA_SPACE = "131072"
SDIMG_ROOTFS_TYPE = "ext4"
IMAGE_FSTYPES = "wic ext4.gz"
NOISO = "0"
NOHDD = "1"
WKS_FILE = "deliapi.wks"

# To make the image read only, uncomment the following line
IMAGE_FEATURES += "read-only-rootfs"
